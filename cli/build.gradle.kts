plugins {
    id("application")
    //id("com.github.johnrengelman.shadow")
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
}

val kotlinCoroutinesVersion: String by properties
val kotlinVersion: String by properties
val ktorVersion: String by properties
val javaVersion = Integer.parseInt(findProperty("javaVersion") as String)
val projectVersion: String by properties
val cliktVersion: String by properties
val okioVersion: String by properties

kotlin {
    jvm() {
        withJava()
    }

    jvmToolchain(javaVersion)

    macosArm64 {
        binaries {
            executable {
                outputDirectory = File("${project.projectDir}/output/macos")
            }
        }
    }

    sourceSets {
        getByName("commonMain").dependencies {
            implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
            implementation("com.squareup.okio:okio:$okioVersion")
            implementation("com.github.ajalt.clikt:clikt:$cliktVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
        }

        getByName("jvmMain").dependencies {
            implementation(project(":shared"))
            runtimeOnly("com.github.ajalt.clikt:clikt-jvm:$cliktVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
        }

        getByName("macosArm64Main").dependencies {
            //implementation(project(":shared"))
            runtimeOnly("com.github.ajalt.clikt:clikt:$cliktVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-client-core")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
        }
    }
}

application {
    mainClass.set("app.raspberryjam.cli.jvm.MainKt")
}

tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = "app.raspberryjam.cli.jvm.MainKt"
    }

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    destinationDirectory.set(File("${project.projectDir}/output/jvm"))
    // To add all of the dependencies
    //from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

java {
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}

//tasks.named("test") {
//    // Use JUnit Platform for unit tests.
//    useJUnitPlatform()
//}

// https://kotlinlang.org/docs/gradle-compiler-options.html#attributes-specific-to-js
// tasks.withType()

tasks.filter { it.name == "clean" }.map {
    it.doFirst {
        delete("${project.projectDir}/output")
    }
}

//val graalvmNativeImageTask = task<Exec>("graalvmNativeImage") {
//    workingDir = File("${project.projectDir}/output/jvm")
//    commandLine = listOf("native-image", "--no-fallback", "-jar", "cli-jvm*jar")
//}

//project(":cli").tasks.register(graalvmNativeImageTask.name)

project(":cli") {
    configure<ExtraPropertiesExtension> {
        task<Exec>("cliGraalvmNativeImage") {
            dependsOn(":cli:build")
            workingDir = File("${project.projectDir}/output/jvm")
            commandLine = listOf("native-image", "--no-fallback", "-jar", "cli-jvm-$projectVersion.jar")
        }
    }
}
