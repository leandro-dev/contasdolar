package com.leandrodev.contasdolar.android.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leandrodev.contasdolar.android.home.HomeScreen.BankList
import com.leandrodev.contasdolar.android.wallet.WalletListScreen
import com.leandrodev.contasdolar.android.wallet.WalletListViewModel
import org.kodein.di.DI
import org.kodein.di.compose.localDI
import org.kodein.di.instance

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
            HomeTopBar {
                val localDi: DI = localDI()
                val factory: ViewModelProvider.Factory by localDi.instance()
                val viewModel: WalletListViewModel = viewModel(
                    factory = factory
                )
                WalletListScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
