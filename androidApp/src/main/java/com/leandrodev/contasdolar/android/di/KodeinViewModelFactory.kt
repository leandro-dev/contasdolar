package com.leandrodev.contasdolar.android.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DI
import org.kodein.di.InstanceOrNull
import org.kodein.type.*

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