package com.leandrodev.shared

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope


actual abstract class MppViewModel

actual val MppViewModel.scope: CoroutineScope
    get() = GlobalScope // TODO Fix this scope
