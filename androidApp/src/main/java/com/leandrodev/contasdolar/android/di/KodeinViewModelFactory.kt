package com.leandrodev.contasdolar.android.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import org.kodein.di.DI
import org.kodein.di.InstanceOrNull
import org.kodein.di.compose.localDI
import org.kodein.type.TypeToken
import org.kodein.type.erased

@Composable
inline fun <reified T : ViewModel> getViewModel(): T {
    val localDi: DI = localDI()
    val factory = KodeinViewModelFactory(localDi)
    return viewModel<T>(
        factory = factory
    )
}

class KodeinViewModelFactory(private val di: DI) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val token: TypeToken<out T> = erased(modelClass)
        val vm: T? by di.InstanceOrNull(token, null)
        return if (vm != null) {
            vm as T
        } else {
            modelClass.newInstance()
        }
    }
}