package com.leandrodev.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

actual object DatabaseImpl : Database {
    override fun getCollection(path: String): Collection {
        return Collection(Firebase.firestore.collection(path))
    }
}
