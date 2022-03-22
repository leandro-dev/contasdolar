import com.leandrodev.platforms.Data

plugins {
    id("com.leandrodev.mpplibrary")
}
version = "1.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Data.commonFirestore)
            }
        }
    }
}
