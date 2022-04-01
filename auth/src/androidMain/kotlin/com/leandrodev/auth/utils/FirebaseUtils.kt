package com.leandrodev.auth.utils

import com.leandrodev.auth.model.User
import dev.gitlive.firebase.auth.FirebaseUser

fun FirebaseUser.toUser(): User {
    return User()
}
