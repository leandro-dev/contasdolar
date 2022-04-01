package com.leandrodev.data

import kotlinx.coroutines.flow.Flow

actual class Collection {

    actual inline fun <reified T : Any> getDataFlow(): Flow<Map<String, T>> {
        TODO("not implemented")
    }

    actual fun getDocument(path: String): Document {
        TODO("not implemented")
    }
}
