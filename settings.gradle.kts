pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    val kotlinVersion = "1.6.10"
    val agpVersion = "7.1.2"
    val composeVersion = "1.1.1"
    val googlePlayServicesVersion = "4.3.10"
    plugins {
        // This is necessary to avoid the plugins to be loaded multiple times in each subproject's classloader
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)
        id("com.google.gms.google-services").version(googlePlayServicesVersion)

        id("org.jetbrains.compose").version(composeVersion)
        id("org.jetbrains.kotlin.kapt").version(kotlinVersion)
        id("org.jetbrains.kotlin.js").version(kotlinVersion)
        id("org.jetbrains.kotlin.plugin.serialization").version(kotlinVersion)
        id("org.jetbrains.kotlin.native.cocoapods").version(kotlinVersion)
    }
}

rootProject.name = "home"

includeBuild("platforms")

// Applications
include(":androidApp")
include(":webApp")

// Core modules
include(":shared")
include(":data")
include(":ui")

// Feature modules
include(":bills")
include(":auth")
