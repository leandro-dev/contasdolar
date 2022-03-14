package com.leandrodev.contasdolar.android.auth.state

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authStateModule = module {
    viewModel<AuthStateViewModel> { AuthStateViewModelImpl() }
}