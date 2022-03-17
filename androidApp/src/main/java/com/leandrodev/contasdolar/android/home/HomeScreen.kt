package com.leandrodev.contasdolar.android.home

enum class HomeScreen {
    BankList;

    companion object {
        fun fromRoute(route: String?): HomeScreen {
            val homeScreen: HomeScreen? = values().find { it.name == route }

            return when {
                homeScreen != null -> homeScreen
                route == null -> BankList
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
        }
    }
}
