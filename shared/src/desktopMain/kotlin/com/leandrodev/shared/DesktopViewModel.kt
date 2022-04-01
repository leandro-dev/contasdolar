package com.leandrodev.shared

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

actual abstract class MppViewModel

@OptIn(DelicateCoroutinesApi::class)
actual val MppViewModel.scope: CoroutineScope
    get() = GlobalScope // TODO Fix this scope

