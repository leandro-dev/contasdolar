package com.leandrodev.platforms

object Versions {
    object Kotlin {
        const val sdk = "1.6.10"
        const val coroutines = "1.6.0"
        const val serialization = "1.3.2"
    }
    object Tests {
        const val junit = "4.13.2"
        const val robolectric = "4.7.3"
        const val androidxJunitRunner = "1.1.3"
        const val androidxTestCore = "1.4.0"
        const val mockk = "1.12.3"
    }
    object DependencyInjection {
        const val kodein = "7.10.0"
    }
    object DataSource {
        const val gitLiveFirestore = "1.4.3"
    }
    object Android {
        object Jetpack {
            const val compose = "1.1.1"
            const val composeJetbrains = "1.1.1"
            const val composeActivity = "1.4.0"
            const val composeNavigation = "2.4.1"
            const val composeConstraintLayout = "1.0.0"
            const val composeImagesCoil = "2.0.0-rc01"
            const val startupRuntime = "1.1.1"
        }
        object Google {
            const val playServicesAuth = "20.1.0"
            const val firebaseBom = "29.1.0"
            const val firebaseBomAuth = "21.0.1"
            const val material = "1.5.0"
            const val lifecycle = "2.4.1"
            const val appCompat = "1.4.1"
        }
        object DeviceTest {
            const val core = "2.1.0"
            const val espresso = "3.4.0"
        }
    }
}
