package com.leandrodev.contasdolar.android.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leandrodev.contasdolar.android.bank.BankListScreen
import com.leandrodev.contasdolar.android.home.HomeScreen.BankList

@Composable
fun HomeNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BankList.name,
        modifier = modifier,
    ) {
        composable(BankList.name) {
            BankListScreen()
        }
    }
}