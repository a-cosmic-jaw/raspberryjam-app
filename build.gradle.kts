

//buildscript {
//    dependencies {
//        val kotlinVersion: String by project
//
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
//    }
//}

plugins {
    id("org.jetbrains.kotlin.multiplatform") apply false
    id("com.github.johnrengelman.shadow") apply false
    id("org.jetbrains.kotlin.plugin.serialization") apply false
    id("org.graalvm.buildtools.native") apply false
    //id("application") apply false
}

allprojects {
    version = "0.0.1"
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