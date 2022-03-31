package com.leandrodev.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.jvm.JvmInline

@JvmInline
value class Collection(
    // This should be private, but JS compilation fails to work with it
    val reference: CollectionReference,
) {
    /**
     * Retrieve a flow from the desired collection that contains a set of values.
     *
     * @return a map where the key is the ID of the element, and the data as value.
     */
    inline fun <reified T : Any> getDataFlow(): Flow<Map<String, T>> {
        return getDataFlow<T>(::parseData)
    }

    inline fun <reified T : Any> getDataFlow(
        crossinline parser: (DocumentSnapshot) -> T
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

    fun getDocument(path: String): Document = Document(
        reference.document(path)
    )
}

@JvmInline
value class Document(private val reference: DocumentReference) {
    fun getCollection(path: String): Collection {
        return Collection(reference.collection(path))
    }
}

interface Database {
    fun getCollection(path: String): Collection
}

object DatabaseImpl : Database {
    override fun getCollection(path: String): Collection {
        return Collection(Firebase.firestore.collection(path))
    }
}