package com.leandrodev.platforms

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

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
}
