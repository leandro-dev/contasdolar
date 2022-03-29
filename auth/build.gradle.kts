import com.leandrodev.platforms.Auth.implementCommonFirebaseAuth

plugins {
    id("com.leandrodev.mpplibrary")
}
version = "1.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(project(":ui"))
                implementCommonFirebaseAuth()
            }
        }
    }
}
