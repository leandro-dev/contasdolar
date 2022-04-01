package com.leandrodev.data

import dev.gitlive.firebase.firestore.DocumentReference

actual class Document(
    private val reference: DocumentReference,
) {
    actual fun getCollection(path: String): Collection {
        return Collection(reference.collection(path))
    }
}
