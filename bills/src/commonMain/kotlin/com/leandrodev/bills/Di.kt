package com.leandrodev.bills

import com.leandrodev.bills.wallet.WalletDataSource
import com.leandrodev.bills.wallet.WalletDataSourceImpl
import com.leandrodev.data.DatabaseImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val billsDiModule = DI.Module("Bills") {
    bindSingleton<WalletDataSource> { WalletDataSourceImpl(DatabaseImpl) }
}
