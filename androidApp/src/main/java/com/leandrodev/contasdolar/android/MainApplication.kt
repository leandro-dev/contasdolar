package com.leandrodev.contasdolar.android

import android.app.Application
import com.leandrodev.contasdolar.android.di.androidAppDi
import org.kodein.di.*

@Suppress("unused")
class MainApplication : Application(), DIAware {
    override val di by DI.lazy {
        import(androidAppDi)
    }
    override val diTrigger = DITrigger()

    override fun onCreate() {
        super.onCreate()
        diTrigger.trigger()
    }
}
