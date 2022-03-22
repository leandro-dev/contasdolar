package com.leandrodev.bills.wallet

import com.leandrodev.bills.wallet.model.Wallet
import com.leandrodev.data.Database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

class WalletDataSourceImpl(
    private val database: Database
) : WalletDataSource {
    override fun getWalletListFlow(): Flow<List<Wallet>> {
        val collection = database
            .getCollection("finance")
            .getDocument("wallet")
            .getCollection("wallet")
        return collection.getDataFlow<WalletModelDataSource>().map { dataMap: Map<String, WalletModelDataSource> ->
            dataMap.toList().map { entry ->
                Wallet(
                    id = entry.first,
                    name = entry.second.name,
                    currentValue = entry.second.currentValue,
                    active = entry.second.active,
                    imageUrl = entry.second.imageUrl ?: "",
                )
            }
        }
    }
}

@Serializable
private data class WalletModelDataSource(
    val active: Boolean,
    val currentValue: Long,
    val name: String,
    val imageUrl: String?,
)
