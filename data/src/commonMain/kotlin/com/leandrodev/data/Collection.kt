package com.leandrodev.data

import kotlinx.coroutines.flow.Flow

expect class Collection {
    inline fun <reified T : Any> getDataFlow(): Flow<Map<String, T>>
    fun getDocument(path: String): Document
}
