plugins {
    id("com.leandrodev.mpplibrary")
}

version = "1.0"

kotlin {
    cocoapods {
        framework {
            baseName = "shared"
        }
    }
}
