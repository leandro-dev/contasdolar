plugins {
    id("com.leandrodev.mpplibrary")
}

group = "com.leandrodev.shared"
version = "1.0"

kotlin {
    cocoapods {
        framework {
            baseName = "shared"
        }
    }
}
