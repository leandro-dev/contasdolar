package com.leandrodev.bills

import com.leandrodev.bills.wallet.WalletDataSource
import com.leandrodev.bills.wallet.WalletDataSourceImpl
import com.leandrodev.data.DatabaseImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val walletDi = DI {
    bindSingleton<WalletDataSource> { WalletDataSourceImpl(DatabaseImpl) }
}
