import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {}
    sourceSets {
        val jvmMain by getting {
            dependencies {
                // Common dependencies
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)

                // Specific dependency
                implementation(compose.desktop.currentOs)
//                implementation(project(":shared"))
//                implementation(project(":data"))
//                implementation(project(":ui"))
//                implementation(project(":auth"))
//                implementation(project(":bills"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.leandrodev.desktop.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Home"
            packageVersion = "1.0.0"

            windows {
                menu = true
                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "15751bb2-7b54-48d5-89b6-0e8051e4e564"
            }

            macOS {
                // Use -Pcompose.desktop.mac.sign=true to sign and notarize.
                // bundleID = "com.jetbrains.compose.codeviewer"
            }
        }
    }
}
