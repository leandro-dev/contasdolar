package com.leandrodev.data

import kotlinx.coroutines.flow.Flow

expect class Collection {
    /**
     * Retrieve a flow from the desired collection that contains a set of values.
     *
     * @return a map where the key is the ID of the element, and the data as value.
     */
    inline fun <reified T : Any> getDataFlow(): Flow<Map<String, T>>
    fun getDocument(path: String): Document
}
