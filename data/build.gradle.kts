import com.leandrodev.platforms.Data.implementCommonFirestore

plugins {
    id("com.leandrodev.mpplibrary")
}
version = "1.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementCommonFirestore()
            }
        }
    }
}
