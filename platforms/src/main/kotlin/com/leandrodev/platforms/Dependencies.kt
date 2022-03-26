@file:Suppress("unused")

package com.leandrodev.platforms

import com.leandrodev.platforms.Configuration.*
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

typealias Dependency = String

val kotlinCommonDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}",
    "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Kotlin.serialization}",
    "org.kodein.di:kodein-di:${Versions.DependencyInjection.kodein}",
)
val kotlinCommonTestDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlin:kotlin-test-common:${Versions.Kotlin.sdk}",
    "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.Kotlin.sdk}",
)
val androidDependencies: List<Dependency> = listOf(
    "androidx.compose.ui:ui-tooling-preview:${Versions.Android.Jetpack.compose}",
    "androidx.compose.ui:ui:${Versions.Android.Jetpack.compose}",
    "androidx.compose.foundation:foundation:${Versions.Android.Jetpack.compose}",
    "androidx.compose.material:material:${Versions.Android.Jetpack.compose}",
    "androidx.compose.material:material-icons-extended:${Versions.Android.Jetpack.compose}",
    "androidx.activity:activity-compose:${Versions.Android.Jetpack.composeActivity}",
    "com.google.accompanist:accompanist-appcompat-theme:0.16.0",
    "androidx.startup:startup-runtime:${Versions.Android.Jetpack.startupRuntime}",
    "androidx.navigation:navigation-compose:${Versions.Android.Jetpack.composeNavigation}",
    "androidx.constraintlayout:constraintlayout-compose:${Versions.Android.Jetpack.composeConstraintLayout}",
    "com.google.android.gms:play-services-auth:${Versions.Android.Google.playServicesAuth}",
    "io.coil-kt:coil-compose:${Versions.Android.Jetpack.composeImagesCoil}",
    "com.google.android.material:material:${Versions.Android.Google.material}",
    "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.Google.lifecycle}",
    "androidx.appcompat:appcompat:${Versions.Android.Google.appCompat}",
    "org.kodein.di:kodein-di-framework-android-x-viewmodel:${Versions.DependencyInjection.kodein}",
    "org.kodein.di:kodein-di-framework-compose:${Versions.DependencyInjection.kodein}",
)
val androidTestDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.sdk}",
    "junit:junit:${Versions.Tests.junit}",
    "org.robolectric:robolectric:${Versions.Tests.robolectric}",
    "androidx.test.ext:junit-ktx:${Versions.Tests.androidxJunitRunner}",
    "androidx.test:core-ktx:${Versions.Tests.androidxTestCore}",
    "io.mockk:mockk:${Versions.Tests.mockk}",
)
val androidDeviceTestDependencies: List<Dependency> = listOf(
    "androidx.arch.core:core-testing:${Versions.Android.DeviceTest.core}",
    "androidx.test.espresso:espresso-contrib:${Versions.Android.DeviceTest.espresso}",
    "androidx.test.espresso:espresso-core:${Versions.Android.DeviceTest.espresso}",
    "androidx.compose.ui:ui-test:${Versions.Android.Jetpack.compose}",
    "androidx.compose.ui:ui-test-junit4:${Versions.Android.Jetpack.compose}",
    // Required because dev.gitlive doesn't find auth version from firebase-bom
    "com.google.firebase:firebase-auth-ktx:${Versions.Android.Google.firebaseBomAuth}",

)
val androidCustomConfigurations: Map<Configuration, List<Dependency>> = mapOf(
    KAPT to listOf("androidx.lifecycle:lifecycle-compiler:${Versions.Android.Google.lifecycle}"),
    DEBUG_IMPLEMENTATION to listOf("androidx.compose.ui:ui-tooling:${Versions.Android.Jetpack.compose}"),
    DEBUG_RUNTIME_ONLY to listOf("androidx.compose.ui:ui-test-manifest:${Versions.Android.Jetpack.compose}"),
)
val androidPlatform: List<Dependency> = listOf(
    "com.google.firebase:firebase-bom:${Versions.Android.Google.firebaseBom}"
)

object Data {
    const val commonFirestore = "dev.gitlive:firebase-firestore:${Versions.Data.firestore}"
}
object Auth {
    const val commonFirebaseAuth = "dev.gitlive:firebase-auth:${Versions.DataSource.gitLiveFirebaseAuth}"
}

fun KotlinSourceSet.applyDependencies(list: List<Dependency>) {
    this.dependencies {
        list.forEach { dependency ->
            this.implementation(dependency)
        }
    }
}
