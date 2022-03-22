package com.leandrodev.bills

import com.leandrodev.data.DatabaseImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

data class Wallet(
    val id: String,
    val name: String,
    val currentValue: Long,
    val active: Boolean,
    val imageUrl: String,
)

@Serializable
data class WalletModelDataSource(
    val active: Boolean,
    val currentValue: Long,
    val name: String,
    val imageUrl: String?,
)

object WalletDataSource {
    fun getWalletListFlow(): Flow<List<Wallet>> {
        val collection = DatabaseImpl
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
