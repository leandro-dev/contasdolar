pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        // This is necessary to avoid the plugins to be loaded multiple times in each subproject's classloader
        kotlin("multiplatform") apply false
        kotlin("android") apply false
        id("com.android.application") apply false
        id("com.android.library") apply false
        id("org.jetbrains.compose") apply false
        id("com.android.application") apply false
        id("org.jetbrains.kotlin.kapt") apply false
        id("org.jetbrains.kotlin.plugin.serialization") apply false
        id("org.jetbrains.kotlin.native.cocoapods") apply false
    }
}

rootProject.name = "Contas_do_Lar"

includeBuild("platforms")

include(":androidApp")
include(":shared")
include(":data")
include(":bills")
include(":ui")
