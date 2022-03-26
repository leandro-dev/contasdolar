package com.leandrodev.auth.di

import com.leandrodev.auth.signin.SignInProvider
import com.leandrodev.auth.signin.SignInProviderImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton

actual val authPlatformModule: DI.Module = DI.Module("AuthAndroid") {
    bindSingleton<SignInProvider> { SignInProviderImpl() }
}
