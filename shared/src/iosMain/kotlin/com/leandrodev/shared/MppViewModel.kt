package com.leandrodev.shared

import kotlinx.coroutines.CoroutineScope

actual abstract class MppViewModel {}

actual val MppViewModel.scope: CoroutineScope
    get() {
        TODO("Implement iOS ViewModelScope version based on it's lifecycle")
    }
