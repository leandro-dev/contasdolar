package com.leandrodev.data

expect class Document {
    fun getCollection(path: String): Collection
}
