pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Contas_do_Lar"
include(":aspects")
include(":androidApp")
include(":shared")
include(":serialization")
include(":data")
include(":network")
