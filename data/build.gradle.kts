import com.leandrodev.platforms.Data.commonFirestore

plugins {
    id("com.leandrodev.mpplibrary")
}
version = "1.0"

kotlin {
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(commonFirestore)
            }
        }
    }
}
