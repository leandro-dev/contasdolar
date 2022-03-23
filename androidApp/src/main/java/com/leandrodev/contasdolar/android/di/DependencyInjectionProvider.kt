package com.leandrodev.contasdolar.android.di

import androidx.lifecycle.ViewModelProvider
import com.leandrodev.bills.billsDiModule
import com.leandrodev.contasdolar.android.wallet.WalletListViewModel
import com.leandrodev.contasdolar.android.wallet.WalletListViewModelImpl
import org.kodein.di.*

val androidAppDi = DI.Module("AndroidApplication") {
    import(androidDi)
}
val androidDi = DI.Module("Android") {
    import(commonDi)
    bind<ViewModelProvider.Factory>() with singleton { KodeinViewModelFactory(di) }
}
val commonDi = DI.Module("Common") {
    import(billsDiModule)

    // TODO Migrate WalletList to bills module
    bindProvider<WalletListViewModel> {
        WalletListViewModelImpl(instance())
    }
}

