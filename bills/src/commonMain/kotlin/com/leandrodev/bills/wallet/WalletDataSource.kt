package com.leandrodev.bills.wallet

import com.leandrodev.bills.wallet.model.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletDataSource {
    fun getWalletListFlow(): Flow<List<Wallet>>
}
