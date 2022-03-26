import com.leandrodev.platforms.Auth
plugins {
    id("com.leandrodev.mpplibrary")
}
version = "1.0"

android {
    kotlinOptions {
        jvmTarget = "11"
    }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(project(":ui"))
                implementation(Auth.commonFirebaseAuth)
            }
        }
    }
}
