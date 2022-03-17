package com.leandrodev.contasdolar.android.bank

import com.leandrodev.contasdolar.MppViewModel
import com.leandrodev.contasdolar.android.utils.ViewState
import com.leandrodev.storage.model.Wallet

sealed interface BankListState {
    object Loading : BankListState
    class Content(val wallets: List<Wallet>) : BankListState
}

abstract class BankListViewModel : MppViewModel() {
    abstract val state: ViewState<BankListState>
}
