plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
    kotlin("kapt")
}
val coroutinesVersion = "1.6.0-native-mt"
val lifecycleVersion = "2.4.1"
val jetpackComposeVersion = "1.1.1"
val jetpackComposeActivityVersion = "1.4.0"
val koinVersion = "3.1.5"

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.leandrodev.contasdolar.android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    /*compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }*/
    composeOptions {
        kotlinCompilerExtensionVersion = jetpackComposeVersion
    }
}

dependencies {
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")

    implementation(project(":aspects"))
    implementation(project(":storage"))

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:$jetpackComposeVersion")
    implementation("androidx.compose.ui:ui-tooling:$jetpackComposeVersion")
    implementation("androidx.compose.foundation:foundation:$jetpackComposeVersion")
    implementation("androidx.compose.material:material:$jetpackComposeVersion")
    implementation("androidx.compose.material:material-icons-extended:$jetpackComposeVersion")
    implementation("androidx.activity:activity-compose:$jetpackComposeActivityVersion")
    implementation("com.google.accompanist:accompanist-appcompat-theme:0.16.0")

    implementation("com.google.android.gms:play-services-auth:20.1.0")

    implementation(platform("com.google.firebase:firebase-bom:29.1.0"))
    implementation("dev.gitlive:firebase-auth:1.4.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")


    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit4:$koinVersion")
}