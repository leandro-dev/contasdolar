package com.leandrodev.data

interface Database {
    fun getCollection(path: String): Collection
}

// TODO Migrate to dependency-injection with kodein
expect object DatabaseImpl : Database
