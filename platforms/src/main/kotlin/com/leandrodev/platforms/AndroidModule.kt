package com.leandrodev.platforms

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

object AndroidModule {
    fun configureAndroidDependencies(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.kapt")
        project.plugins.apply("org.jetbrains.kotlin.plugin.serialization")

        with(project.dependencies) {
            applyDependencies("implementation", androidDependencies)
            applyDependencies("testImplementation", androidTestDependencies)
            applyDependencies("androidTestImplementation", androidDeviceTestDependencies)
            androidCustomConfigurations.forEach { (configuration, dependencies) ->
                applyDependencies(configuration.configurationName, dependencies)
            }
            androidPlatform.forEach {
                platform(it)
            }
        }
    }

    fun DependencyHandler.applyDependencies(
        configurationName: String,
        list: List<Dependency>,
    ) {
        list.forEach { dependency ->
            this.add(configurationName, dependency)
        }
    }

    fun LibraryExtension.`kotlinOptions`(configure: Action<KotlinJvmOptions>): Unit =
        (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
}
