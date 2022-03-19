package com.leandrodev.contasdolar.android.wallet

import com.leandrodev.contasdolar.MppViewModel
import com.leandrodev.contasdolar.android.utils.ViewState
import com.leandrodev.data.model.Wallet

sealed interface WalletListState {
    object Loading : WalletListState
    class Content(val wallets: List<Wallet>) : WalletListState
}

abstract class WalletListViewModel : MppViewModel() {
    abstract val state: ViewState<WalletListState>
}
