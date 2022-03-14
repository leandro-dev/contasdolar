package com.leandrodev.contasdolar.android.auth

import com.leandrodev.contasdolar.android.auth.google.SignInProvider
import com.leandrodev.contasdolar.android.auth.google.SignInProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel<AuthViewModel> { AuthViewModelImpl(androidContext()) }
    single<SignInProvider> { SignInProviderImpl() }
}
