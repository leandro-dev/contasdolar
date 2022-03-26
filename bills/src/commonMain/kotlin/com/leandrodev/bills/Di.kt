package com.leandrodev.bills

import com.leandrodev.bills.wallet.datasource.WalletDataSource
import com.leandrodev.bills.wallet.datasource.WalletDataSourceImpl
import com.leandrodev.bills.wallet.list.WalletListViewModel
import com.leandrodev.bills.wallet.list.WalletListViewModelImpl
import com.leandrodev.data.DatabaseImpl
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val billsDiModule = DI.Module("Bills") {
    bindSingleton<WalletDataSource> { WalletDataSourceImpl(DatabaseImpl) }
    bindProvider<WalletListViewModel> {
        WalletListViewModelImpl(instance())
    }
}
