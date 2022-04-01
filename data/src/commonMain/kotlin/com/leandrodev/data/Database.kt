package com.leandrodev.data

interface Database {
    fun getCollection(path: String): Collection
}

expect class DatabaseImpl() : Database
