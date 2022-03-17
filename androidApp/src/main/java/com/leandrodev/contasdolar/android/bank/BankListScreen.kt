package com.leandrodev.contasdolar.android.bank

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch

@Composable
fun BankListScreen(
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    Column(modifier) {
        Text(text = "Authenticated. Bank List will be displayed here")
        Button(onClick = {
            scope.launch {
                Firebase.auth.signOut()
            }
        }) {
            Text(text = "Sign out")
        }
    }
}
