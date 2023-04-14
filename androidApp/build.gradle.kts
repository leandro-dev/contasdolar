plugins {
    id("com.leandrodev.android-application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.leandrodev.contasdolar.android"
    defaultConfig {
        applicationId = "com.leandrodev.contasdolar.android"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":bills"))
    implementation(project(":auth"))
}