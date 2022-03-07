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
val robolectricVersion = "4.7.3"
val androidXTestExtKotlinRunnerVersion = "1.1.3"
val androidXTestCoreVersion = "1.4.0"
val coreTestingVersion = "2.1.0"
val espressoVersion = "3.4.0"

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.leandrodev.contasdolar.android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true

        // Disable unused AGP features
        aidl = false
        renderScript = false
        shaders = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = jetpackComposeVersion
    }
    testOptions.unitTests {
        isIncludeAndroidResources = true
    }
}

dependencies {
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")

    implementation(project(":aspects"))
    implementation(project(":storage"))

    // Jetpack Compose
    debugImplementation("androidx.compose.ui:ui-tooling:$jetpackComposeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$jetpackComposeVersion")
    implementation("androidx.compose.ui:ui:$jetpackComposeVersion")
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
    testImplementation("org.robolectric:robolectric:$robolectricVersion")
    testImplementation("androidx.test.ext:junit-ktx:$androidXTestExtKotlinRunnerVersion")
    testImplementation("androidx.test:core-ktx:$androidXTestCoreVersion")


    androidTestImplementation("androidx.arch.core:core-testing:$coreTestingVersion")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:$espressoVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("androidx.compose.ui:ui-test:$jetpackComposeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$jetpackComposeVersion")
    debugRuntimeOnly("androidx.compose.ui:ui-test-manifest:$jetpackComposeVersion")
}