package com.leandrodev.auth.di

import com.leandrodev.auth.state.AuthStateViewModel
import com.leandrodev.auth.state.AuthStateViewModelJs
import org.kodein.di.DI
import org.kodein.di.bindProvider

actual val authPlatformModule: DI.Module = DI.Module("AuthJs") {
    bindProvider<AuthStateViewModel> { AuthStateViewModelJs() }
}
