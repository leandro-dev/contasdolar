package com.leandrodev.contasdolar.android.di

import android.content.Context
import androidx.startup.Initializer
import com.leandrodev.contasdolar.android.BuildConfig
import com.leandrodev.contasdolar.android.auth.signin.authModule
import com.leandrodev.contasdolar.android.auth.state.authStateModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

object DependencyInjectionInitialized

@Suppress("unused")
class DependencyInjectionInitializer : Initializer<DependencyInjectionInitialized> {
    override fun create(context: Context): DependencyInjectionInitialized {
        if (GlobalContext.getOrNull() == null) {
            startKoin {
                this@startKoin.configureDependencies(context.applicationContext)
            }
        }
        return DependencyInjectionInitialized
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}

fun KoinApplication.configureDependencies(
    androidContext: Context
) {
    androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
    androidContext(androidContext)
    modules(authModule, authStateModule)
}