package com.leandrodev.platforms

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.KotlinCocoapodsPlugin.Companion.COCOAPODS_EXTENSION_NAME

open class MppLibrary : Plugin<Project> {

    override fun apply(target: Project) {
        configureKotlinMultiplatform(target)
        configureAndroidLibrary(target)
        configureIosCocoapods(target)
        configureKotlinSerialization(target)
    }

    private fun configureKotlinMultiplatform(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.multiplatform")
        project.extensions.configure(KotlinMultiplatformExtension::class.java) {
            android()
            iosX64()
            iosArm64()
            iosSimulatorArm64() // Make sure all ios dependencies support this target
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
                val iosX64Main = maybeCreate("iosX64Main")
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
                }
            }
        }
    }

    private fun configureAndroidLibrary(project: Project) {
        project.plugins.apply("com.android.library")
        project.extensions.configure(BaseExtension::class.java) {
            setCompileSdkVersion(31)
            sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
            defaultConfig {
                minSdk = 23
                targetSdk = 31
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

    private fun configureKotlinSerialization(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.plugin.serialization")
    }
}