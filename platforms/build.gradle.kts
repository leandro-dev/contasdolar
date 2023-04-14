plugins {
    java
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

val kotlinVersion = "1.8.20"
val agpVersion = "8.0.0"
val composeVersion = "1.4.0"
dependencies {
    compileOnly(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")
    implementation("com.android.tools.build:gradle:$agpVersion")
    implementation("org.jetbrains.compose:compose-gradle-plugin:$composeVersion")
}

gradlePlugin {
    plugins {
        register("mpp-library") {
            id = "com.leandrodev.mpplibrary"
            implementationClass = "com.leandrodev.platforms.MppLibrary"
        }
        register("android-application") {
            id = "com.leandrodev.android-application"
            implementationClass = "com.leandrodev.platforms.AndroidApplication"
        }
    }
}
