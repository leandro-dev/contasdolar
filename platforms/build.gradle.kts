buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
    }
}

plugins {
    java
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
}

val kotlinVersion = "1.5.31"
dependencies {
    compileOnly(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")
    implementation("com.android.tools.build:gradle:7.1.2")
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
