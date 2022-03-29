buildscript {
    repositories {
        google()
        mavenCentral()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.1.0")
    }
}

plugins {
    java
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val kotlinVersion = "1.6.10"
dependencies {
    compileOnly(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.1.0")
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
