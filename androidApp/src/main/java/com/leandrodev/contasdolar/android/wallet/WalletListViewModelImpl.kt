package com.leandrodev.contasdolar.android.wallet

import androidx.lifecycle.viewModelScope
import com.leandrodev.bills.wallet.WalletDataSource
import com.leandrodev.contasdolar.android.utils.MutableViewState
import com.leandrodev.contasdolar.android.utils.createViewAction
import kotlinx.coroutines.launch

class WalletListViewModelImpl(
    private val walletDataSource: WalletDataSource,
) : WalletListViewModel() {
    override val state: MutableViewState<WalletListState> = createViewAction()

    init {
        viewModelScope.launch {
            state.emit(WalletListState.Loading)

            walletDataSource.getWalletListFlow().collect { walletList ->
                state.emit(WalletListState.Content(walletList))
            }
        }
    }
}
