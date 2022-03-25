package com.leandrodev.bills.wallet.list

import com.leandrodev.bills.wallet.datasource.WalletDataSource
import com.leandrodev.contasdolar.MutableViewState
import com.leandrodev.contasdolar.createViewAction
import com.leandrodev.contasdolar.scope
import kotlinx.coroutines.launch

class WalletListViewModelImpl(
    private val walletDataSource: WalletDataSource,
) : WalletListViewModel() {
    override val state: MutableViewState<WalletListState> = createViewAction()

    init {
        scope.launch {
            state.emit(WalletListState.Loading)

            walletDataSource.getWalletListFlow().collect { walletList ->
                state.emit(WalletListState.Content(walletList))
            }
        }
    }
}
