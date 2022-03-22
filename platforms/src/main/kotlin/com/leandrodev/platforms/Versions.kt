package com.leandrodev.platforms

object Versions {
    object Kotlin {
        const val sdk = "1.6.10"
        const val coroutines = "1.6.0-native-mt"
        const val serialization = "1.3.2"
    }
    object Tests {
        const val junit = "4.13.2"
        const val robolectric = "4.7.3"
        const val androidxJunitRunner = "1.1.3"
        const val androidxTestCore = "1.4.0"
    }
    object Data {
        const val firestore = "1.4.3"
    }
    object DependencyInjection {
        const val kodein = "7.10.0"
    }
    object Android {
        const val jetpackCompose = "1.1.1"
        object Jetpack {
            const val compose = "1.1.1"
            const val composeActivity = "1.4.0"
            const val composeNavigation = "2.4.1"
            const val composeConstraintLayout = "1.0.0"
            const val startupRuntime = "1.1.1"
        }
    }
}
