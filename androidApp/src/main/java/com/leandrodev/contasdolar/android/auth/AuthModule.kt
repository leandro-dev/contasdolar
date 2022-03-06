package com.leandrodev.contasdolar.android.auth

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val authModule = module {
    viewModel { AuthViewModel() }
}