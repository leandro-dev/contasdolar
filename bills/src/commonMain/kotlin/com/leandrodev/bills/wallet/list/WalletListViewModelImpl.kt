package com.leandrodev.bills.wallet.list

import com.leandrodev.bills.wallet.datasource.WalletDataSource
import com.leandrodev.shared.MutableViewState
import com.leandrodev.shared.createViewAction
import com.leandrodev.shared.scope
import kotlinx.coroutines.launch

internal class WalletListViewModelImpl(
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
