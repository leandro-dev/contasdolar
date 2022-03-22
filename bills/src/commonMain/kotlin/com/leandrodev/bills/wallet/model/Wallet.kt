package com.leandrodev.bills.wallet.model

data class Wallet(
    val id: String,
    val name: String,
    val currentValue: Long,
    val active: Boolean,
    val imageUrl: String,
)