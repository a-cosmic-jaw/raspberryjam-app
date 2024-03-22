plugins {
    id("application")
    id("com.github.johnrengelman.shadow")
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
}

val cliktVersion: String by project
val kotlinCoroutinesVersion: String by project
val kotlinVersion: String by project
val ktorVersion: String by project
val mordantVersion: String by project

kotlin {
    jvm() {
        withJava()
    }

    macosArm64 {
        binaries {
            executable {

            }
        }
    }

    sourceSets {
        getByName("commonMain").dependencies {
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
        }

        getByName("jvmMain").dependencies {
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
        }

        getByName("macosArm64Main").dependencies {
            implementation("com.github.ajalt.mordant:mordant:$mordantVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
        }
    }
}

application {
    mainClass.set("app.raspberryjam.cli.JvmMainKt")
}

tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = "app.raspberryjam.cli.JvmMainKt"
    }

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all of the dependencies
    //from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

//tasks.named("test") {
//    // Use JUnit Platform for unit tests.
//    useJUnitPlatform()
//}

