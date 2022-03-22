package com.leandrodev.platforms

import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

typealias Dependency = String

val kotlinCommonDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}",
    "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Kotlin.serialization}",
    "org.kodein.di:kodein-di:${Versions.DependencyInjection.kodein}"
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
)
val androidTestDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.sdk}",
    "junit:junit:${Versions.Tests.junit}",
    "org.robolectric:robolectric:${Versions.Tests.robolectric}",
    "androidx.test.ext:junit-ktx:${Versions.Tests.androidxJunitRunner}",
    "androidx.test:core-ktx:${Versions.Tests.androidxTestCore}",
)

object Data {
    val commonFirestore = "dev.gitlive:firebase-firestore:${Versions.Data.firestore}"
}

fun KotlinSourceSet.applyDependencies(list: List<Dependency>) {
    this.dependencies {
        list.forEach { dependency ->
            this.implementation(dependency)
        }
    }
}
