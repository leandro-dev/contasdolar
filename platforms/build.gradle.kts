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

val kotlinVersion = "1.6.10"
val agpVersion = "7.1.2"
val composeVersion = "1.1.0"
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
