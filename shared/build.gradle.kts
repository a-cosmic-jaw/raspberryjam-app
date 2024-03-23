plugins {
    id("org.jetbrains.kotlin.multiplatform")
    //id("org.jetbrains.kotlin.plugin.allopen") version "1.9.23"
    //id("com.google.devtools.ksp") version "1.9.23-1.0.19"
    //id("com.github.johnrengelman.shadow")

    //`java-library`
}

val kotlinVersion: String by project.properties
val kotlinCoroutinesVersion: String by project
val javaVersion: String by project
val ivyVersion: String by project
val junitVersion: String by project

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")

                implementation("org.jetbrains.kotlin:kotlin-scripting-common:$kotlinVersion")
                implementation("org.jetbrains.kotlin:kotlin-scripting-jvm:$kotlinVersion")
                implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host:$kotlinVersion")
                implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies:$kotlinVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
                implementation("org.apache.ivy:ivy:$ivyVersion")

                runtimeOnly("org.jetbrains.kotlin:kotlin-scripting-jsr223:$kotlinVersion")
            }
        }
        val jvmTest by getting {
            dependencies {
                runtimeOnly("org.jetbrains.kotlin:kotlin-scripting-jsr223:$kotlinVersion")
                implementation("junit:junit:$junitVersion")
            }
        }
    }

}


java {
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
}
