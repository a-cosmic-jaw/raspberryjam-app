

//buildscript {
//    dependencies {
//        val kotlinVersion: String by project
//
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
//    }
//}

plugins {
    id("org.jetbrains.kotlin.multiplatform") apply false
    id("org.jetbrains.kotlin.jvm") apply false
    id("com.github.johnrengelman.shadow") apply false
    id("org.jetbrains.kotlin.plugin.serialization") apply false
}

val projectVersion: String by properties

allprojects {
    version = projectVersion
    group = "app.raspberryjam"

    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://plugins.gradle.org/m2/")
    }
}

subprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://plugins.gradle.org/m2/")
    }
}
