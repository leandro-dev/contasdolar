package com.leandrodev.contasdolar.android.model

data class Wallet(
    val id: Long,
    val name: String,
    val currentValue: Long,
    val active: Boolean,
)
