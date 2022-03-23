package com.leandrodev.contasdolar.android.di

import com.leandrodev.bills.billsDiModule
import com.leandrodev.contasdolar.android.wallet.WalletListViewModel
import com.leandrodev.contasdolar.android.wallet.WalletListViewModelImpl
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val androidAppDi = DI.Module("AndroidApplication") {
    import(commonDi)
}
val commonDi = DI.Module("Common") {
    import(billsDiModule)

    // TODO Migrate WalletList to bills module
    bindProvider<WalletListViewModel> {
        WalletListViewModelImpl(instance())
    }
}

