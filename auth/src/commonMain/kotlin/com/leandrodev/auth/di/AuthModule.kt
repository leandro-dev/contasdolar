package com.leandrodev.auth.di

import com.leandrodev.auth.signin.SignInViewModel
import com.leandrodev.auth.signin.SignInViewModelImpl
import org.kodein.di.DI
import org.kodein.di.bindProvider

val authModule = DI.Module("Auth") {
    import(authPlatformModule)
    bindProvider<SignInViewModel> { SignInViewModelImpl() }
}

expect val authPlatformModule: DI.Module
