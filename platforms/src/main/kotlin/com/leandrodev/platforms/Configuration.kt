package com.leandrodev.platforms

enum class Configuration(
    val configurationName: String,
) {
    KAPT("kapt"),
    DEBUG_IMPLEMENTATION("debugImplementation"),
    DEBUG_RUNTIME_ONLY("debugRuntimeOnly"),
    ;
}
