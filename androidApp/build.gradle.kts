plugins {
    id("com.leandrodev.android-application")
    id("com.google.gms.google-services")
}
val koinVersion = "3.1.5"

android {
    defaultConfig {
        applicationId = "com.leandrodev.contasdolar.android"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":aspects"))
    implementation(project(":data"))
    implementation(project(":bills"))

    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit4:$koinVersion")
}