package com.leandrodev.platforms

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.leandrodev.platforms.AndroidModule.applyDependencies
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("UnstableApiUsage")
open class AndroidApplication : Plugin<Project> {

    override fun apply(target: Project) {
        configureAndroidApplication(target)
    }

    private fun configureAndroidApplication(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.android")
        project.plugins.apply("com.android.application")
        AndroidModule.configureAndroidDependencies(project)
        with(project.dependencies) {
            applyDependencies("implementation", kotlinCommonDependencies)
            applyDependencies("testImplementation", kotlinCommonTestDependencies)
        }
        project.extensions.configure(BaseAppModuleExtension::class.java) {
            setCompileSdkVersion(31)
            defaultConfig {
                minSdk = 23
                targetSdk = 31
                versionCode = 1
                versionName = "1.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            buildFeatures {
                compose = true
                // Disable unused AGP features
                aidl = false
                renderScript = false
                shaders = false
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