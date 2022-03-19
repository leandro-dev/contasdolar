package com.leandrodev.contasdolar.android.wallet

import androidx.lifecycle.viewModelScope
import com.leandrodev.contasdolar.android.utils.MutableViewState
import com.leandrodev.contasdolar.android.utils.createViewAction
import com.leandrodev.data.getWalletListFlow
import kotlinx.coroutines.launch

class WalletListViewModelImpl : WalletListViewModel() {
    override val state: MutableViewState<WalletListState> = createViewAction()

    init {
        viewModelScope.launch {
            state.emit(WalletListState.Loading)

            getWalletListFlow().collect { walletList ->
                state.emit(WalletListState.Content(walletList))
            }
        }
    }
}
