plugins {
    //id("kotlin")
    //id("org.jetbrains.kotlin")
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("application")
    id("com.github.johnrengelman.shadow")
}

val ktorVersion: String by project
val kotlinCoroutinesVersion: String by project
val cliktVersion: String by project

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                runtimeOnly("com.github.ajalt.clikt:clikt:$cliktVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
                //implementation("io.ktor:ktor-client-core:2.3.9")
                //implementation("io.ktor:ktor-client-content-negotiation:2.3.9")
                //implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.9")
                implementation("com.github.ajalt.mordant:mordant:2.2.0")

                //runtimeOnly("com.github.ajalt.clikt:clikt-jvm:$cliktVersion")
                // https://mvnrepository.com/artifact/com.github.ajalt.clikt/clikt-metadata
                //implementation("com.github.ajalt.clikt:clikt-metadata:3.1.0")
             //   testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
             //   testRuntimeOnly("org.junit.platform:junit-platform-launcher")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("com.github.ajalt.clikt:clikt-jvm:$cliktVersion")
            }
        }
    }
}


application {
    mainClass.set("app.raspberryjam.cli.MainKt")
}

//tasks.named("test") {
//    // Use JUnit Platform for unit tests.
//    useJUnitPlatform()
//}

