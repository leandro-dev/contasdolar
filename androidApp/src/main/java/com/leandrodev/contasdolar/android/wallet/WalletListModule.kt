package com.leandrodev.contasdolar.android.wallet

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val walletListModule = module {
    viewModel<WalletListViewModel> { WalletListViewModelImpl() }
}
