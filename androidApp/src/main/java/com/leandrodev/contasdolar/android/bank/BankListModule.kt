package com.leandrodev.contasdolar.android.bank

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bankListModule = module {
    viewModel<BankListViewModel> { BankListViewModelImpl() }
}
