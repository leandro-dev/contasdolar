package com.leandrodev.storage

import com.leandrodev.storage.model.Wallet
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

@Serializable
data class WalletModelDataSource(
    val active: Boolean,
    val currentValue: Long,
    val name: String,
)

suspend fun getWalletListFlow(): Flow<List<Wallet>> {
    val collection = Firebase.firestore
        .collection("finance")
        .document("wallet")
        .collection("wallet")
    return collection.snapshots.map { querySnapshot ->
        querySnapshot.documents.map {
            val id: String = it.id
            val data = it.data<WalletModelDataSource>()
            Wallet(
                id = id,
                name = data.name,
                currentValue = data.currentValue,
                active = data.active
            )
        }
    }

}
