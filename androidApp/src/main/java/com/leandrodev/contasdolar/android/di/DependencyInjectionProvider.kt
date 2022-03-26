package com.leandrodev.contasdolar.android.di

import com.leandrodev.auth.di.authModule
import com.leandrodev.bills.billsDiModule
import org.kodein.di.DI

val androidAppDi = DI.Module("AndroidApplication") {
    import(billsDiModule)
    import(authModule)
}
