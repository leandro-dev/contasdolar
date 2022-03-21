package com.leandrodev.platforms

import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

typealias Dependency = String

val kotlinCommonDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutines}",
)
val kotlinCommonTestDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlin:kotlin-test-common:${Versions.Kotlin.sdk}",
    "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.Kotlin.sdk}",
)
val androidDependencies: List<Dependency> = listOf()
val androidTestDependencies: List<Dependency> = listOf(
    "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.sdk}",
    "junit:junit:${Versions.Tests.junit}",
)

fun KotlinSourceSet.applyDependencies(list: List<Dependency>) {
    this.dependencies {
        list.forEach { dependency ->
            this.implementation(dependency)
        }
    }
}
