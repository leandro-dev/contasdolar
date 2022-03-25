package com.leandrodev.bills

import com.leandrodev.bills.wallet.datasource.WalletDataSource
import com.leandrodev.bills.wallet.datasource.WalletDataSourceImpl
import com.leandrodev.data.DatabaseImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val billsDiModule = DI.Module("Bills") {
    bindSingleton<WalletDataSource> { WalletDataSourceImpl(DatabaseImpl) }
}
