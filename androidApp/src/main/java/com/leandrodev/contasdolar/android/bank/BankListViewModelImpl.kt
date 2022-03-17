package com.leandrodev.contasdolar.android.bank

import com.leandrodev.contasdolar.android.utils.MutableViewState
import com.leandrodev.contasdolar.android.utils.createViewAction

class BankListViewModelImpl : BankListViewModel() {
    override val state: MutableViewState<BankListState> = createViewAction()
}
