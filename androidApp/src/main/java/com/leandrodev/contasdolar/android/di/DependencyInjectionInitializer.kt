package com.leandrodev.contasdolar.android.di

import android.content.Context
import androidx.startup.Initializer

object DependencyInjectionInitialized

@Suppress("unused")
class DependencyInjectionInitializer : Initializer<DependencyInjectionInitialized> {
    override fun create(context: Context): DependencyInjectionInitialized {
        // TODO: Attempt to start kodein here instead of using application
        return DependencyInjectionInitialized
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}