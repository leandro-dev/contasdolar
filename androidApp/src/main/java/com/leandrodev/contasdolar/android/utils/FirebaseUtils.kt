package com.leandrodev.contasdolar.android.utils

import com.leandrodev.contasdolar.android.model.User
import dev.gitlive.firebase.auth.FirebaseUser

fun FirebaseUser.toUser(): User {
    return User()
}