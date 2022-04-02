@file:Suppress("UnstableApiUsage", "USELESS_CAST")

package com.leandrodev.platforms

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.KotlinCocoapodsPlugin.Companion.COCOAPODS_EXTENSION_NAME

open class MppLibrary : Plugin<Project> {

    override fun apply(target: Project) {
        configureKotlinMultiplatform(target)
        configureAndroidLibrary(target)
//        configureIosCocoapods(target)
    }

    private fun configureKotlinMultiplatform(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.multiplatform")
        project.plugins.apply("org.jetbrains.compose")
        project.extensions.configure(KotlinMultiplatformExtension::class.java) {
            // This allows to edit with autocompletion when IDE fails to work properly
            with(this as KotlinMultiplatformExtension) {
                android()
                js(IR) {
                    browser()
                    binaries.executable()
                }
                jvm("desktop")
                /*iosX64()
                iosArm64()
                iosSimulatorArm64() // Make sure all ios dependencies support this target*/
                sourceSets.run {
                    val commonMain = maybeCreate("commonMain").apply {
                        applyDependencies(kotlinCommonDependencies)
                    }
                    val commonTest = maybeCreate("commonTest").apply {
                        applyDependencies(kotlinCommonTestDependencies)
                    }
                    maybeCreate("androidMain").apply {
                        applyDependencies(androidDependencies)
                    }
                    maybeCreate("androidTest").apply {
                        applyDependencies(androidTestDependencies)
                    }
                    maybeCreate("jsMain").apply {
                        dependencies {
                            implementation(compose.web.core)
                            implementation(compose.runtime)
                        }
                    }
                    named("desktopMain") {
                        kotlin.srcDirs("src/desktopMain/kotlin")
                        dependencies {
                            implementation(compose.desktop.common)
                        }
                    }
                    /*val iosX64Main = maybeCreate("iosX64Main")
                    val iosArm64Main = maybeCreate("iosArm64Main")
                    val iosSimulatorArm64Main = maybeCreate("iosSimulatorArm64Main")
                    create("iosMain") {
                        dependsOn(commonMain)
                        iosX64Main.dependsOn(this)
                        iosArm64Main.dependsOn(this)
                        iosSimulatorArm64Main.dependsOn(this)
                    }
                    val iosX64Test = maybeCreate("iosX64Test")
                    val iosArm64Test = maybeCreate("iosArm64Test")
                    val iosSimulatorArm64Test = maybeCreate("iosSimulatorArm64Test")
                    create("iosTest") {
                        dependsOn(commonTest)
                        iosX64Test.dependsOn(this)
                        iosArm64Test.dependsOn(this)
                        iosSimulatorArm64Test.dependsOn(this)
                    }*/
                }
            }
        }
    }

    private fun configureAndroidLibrary(project: Project) {
        project.plugins.apply("com.android.library")
        AndroidModule.configureAndroidDependencies(project)
        project.extensions.configure(LibraryExtension::class.java) {
            // This allows to edit with autocompletion when IDE fails to work properly
            with(this as LibraryExtension) {
                kotlinOptions {
                    jvmTarget = "11"
                }
                buildFeatures {
                    compose = true
                    // Disable unused AGP features
                    aidl = false
                    renderScript = false
                    shaders = false
                }
                setCompileSdkVersion(31)
                sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
                sourceSets.getByName("main").res.srcDirs("src/androidMain/res")
                defaultConfig {
                    minSdk = 23
                    targetSdk = 31
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = Versions.Android.Jetpack.compose
                }
                testOptions.unitTests {
                    isIncludeAndroidResources = true
                }
            }
        }
    }

    private fun configureIosCocoapods(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.native.cocoapods")
        val kotlinExtensionAware = (project.extensions.getByName("kotlin") as ExtensionAware)
        val extension = kotlinExtensionAware.extensions.getByName(COCOAPODS_EXTENSION_NAME) as CocoapodsExtension
        extension.apply {
            summary = "Some description for the Shared Module"
            homepage = "Link to the Shared Module homepage"
            ios.deploymentTarget = "15.0"
            podfile = project.file("../iosApp/Podfile")
            framework {
                baseName = "shared"
            }
        }
    }
}
