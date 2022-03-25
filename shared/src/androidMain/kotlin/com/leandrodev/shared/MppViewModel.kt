package com.leandrodev.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual typealias MppViewModel = ViewModel

actual val MppViewModel.scope: CoroutineScope
    get() = viewModelScope
