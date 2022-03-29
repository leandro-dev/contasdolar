import java.net.URI

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
        id("org.jetbrains.kotlin.js") apply false
        id("org.jetbrains.kotlin.plugin.serialization") apply false
        id("org.jetbrains.kotlin.native.cocoapods") apply false
    }
}

/*
 * Project dev.gitlive version 1.4.3 does not yet contain the js(IR) required to work with compose.
 * Remove this code when they publish another version
 */
sourceControl {
    gitRepository(URI("https://github.com/GitLiveApp/firebase-kotlin-sdk.git")) {
        producesModule("dev.gitlive:firebase-auth")
        producesModule("dev.gitlive:firebase-firestore")
//        plugins {
//            id("org.jetbrains.kotlin.multiplatform")// version "1.5.31" apply false
//            id("base")
//        }
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
