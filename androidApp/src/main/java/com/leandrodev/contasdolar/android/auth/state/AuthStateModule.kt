package com.leandrodev.contasdolar.android.auth.state

import org.kodein.di.DI
import org.kodein.di.bindProvider

val authStateModule = DI.Module("AuthState") {
    bindProvider<AuthStateViewModel> { AuthStateViewModelImpl() }
}
