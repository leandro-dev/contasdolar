plugins {
    id("com.leandrodev.mpplibrary")
}

group = "com.leandrodev.shared"
version = "1.0"

kotlin {
    jvm("desktop")
    sourceSets {
        named("desktopMain") {
            kotlin.srcDirs("src/desktopMain/kotlin")
            dependencies {
                api(compose.desktop.common)
            }
        }
    }
}
