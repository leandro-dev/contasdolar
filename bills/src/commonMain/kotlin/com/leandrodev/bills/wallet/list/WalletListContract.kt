package com.leandrodev.bills.wallet.list

import com.leandrodev.bills.wallet.model.Wallet
import com.leandrodev.contasdolar.MppViewModel
import com.leandrodev.contasdolar.ViewState

sealed interface WalletListState {
    object Loading : WalletListState
    class Content(val wallets: List<Wallet>) : WalletListState
}

abstract class WalletListViewModel : MppViewModel() {
    abstract val state: ViewState<WalletListState>
}
