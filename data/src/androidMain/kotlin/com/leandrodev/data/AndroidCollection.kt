package com.leandrodev.data

import dev.gitlive.firebase.firestore.CollectionReference
import dev.gitlive.firebase.firestore.DocumentSnapshot
import dev.gitlive.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

actual class Collection(
    private val reference: CollectionReference,
) {
    actual inline fun <reified T : Any> getDataFlow(): Flow<Map<String, T>> {
        return getDataFlowInternal<T>(::parseData)
    }

    fun <T : Any> getDataFlowInternal(
        parser: (DocumentSnapshot) -> T
    ): Flow<Map<String, T>> {
        return reference.snapshots.map { snapshot: QuerySnapshot ->
            snapshot.documents.associate {
                it.id to parser(it)
            }
        }
    }

    inline fun <reified T: Any> parseData(snapshot: DocumentSnapshot): T {
        return snapshot.data()
    }

    actual fun getDocument(path: String): Document = Document(
        reference.document(path)
    )
}
