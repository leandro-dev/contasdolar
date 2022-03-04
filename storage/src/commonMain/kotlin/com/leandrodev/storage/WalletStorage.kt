package com.leandrodev.storage

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore


suspend fun testFirebase(): String {
    val document = Firebase.firestore.collection("finance").document("wallet")
    val data = document.get()
    val map = data.data<Map<String, String>>()
    return map.getOrElse("a") { "fail" }
}