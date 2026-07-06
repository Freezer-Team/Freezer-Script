// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.0")
    }
}

plugins {
    id("com.android.application") version "9.2.1" apply false
    id("com.android.library") version "9.2.1" apply false
    id("org.jetbrains.kotlin.android") version "2.4.0" apply false
    id("org.lsposed.lsparanoid") version "0.6.0"
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
