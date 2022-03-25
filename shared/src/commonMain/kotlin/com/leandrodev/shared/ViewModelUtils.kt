package com.leandrodev.shared

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

typealias ViewState<T> = SharedFlow<T>
typealias MutableViewState<T> = MutableSharedFlow<T>

typealias ViewAction<T> = SharedFlow<T>
typealias MutableViewAction<T> = MutableSharedFlow<T>

fun <T> createViewAction(): MutableViewAction<T> = MutableSharedFlow<T>(
    extraBufferCapacity = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST,
    replay = 1
)
