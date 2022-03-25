package com.leandrodev.shared

import kotlinx.coroutines.CoroutineScope

/*
 * Currently the ViewModel is not an interface to help providing the coroutine context.
 *
 * This is to avoid sending the context on ViewModel's constructor and to avoid creating a wrapper Android ViewModel
 * for every ViewModel multiplatform class.
 *
 * With context-receivers from Kotlin, there seems to be a better approach that helps on the coroutine context issue.
 * https://github.com/Kotlin/KEEP/issues/259
 */
expect abstract class MppViewModel() {
}

expect val MppViewModel.scope: CoroutineScope
