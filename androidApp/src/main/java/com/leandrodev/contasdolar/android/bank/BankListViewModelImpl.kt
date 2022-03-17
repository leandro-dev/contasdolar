package com.leandrodev.contasdolar.android.bank

import androidx.lifecycle.viewModelScope
import com.leandrodev.contasdolar.android.utils.MutableViewState
import com.leandrodev.contasdolar.android.utils.createViewAction
import com.leandrodev.storage.getWalletListFlow
import kotlinx.coroutines.launch

class BankListViewModelImpl : BankListViewModel() {
    override val state: MutableViewState<BankListState> = createViewAction()

    init {
        viewModelScope.launch {
            state.emit(BankListState.Loading)

            getWalletListFlow().collect { walletList ->
                state.emit(BankListState.Content(walletList))
            }
        }
    }
}
