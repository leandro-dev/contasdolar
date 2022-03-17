package com.leandrodev.contasdolar.android.bank

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.leandrodev.storage.model.Wallet
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun BankListScreen(
    modifier: Modifier = Modifier,
    viewModel: BankListViewModel = getViewModel()
) {
    val scope = rememberCoroutineScope()
    val state: BankListState by viewModel.state.collectAsState(initial = BankListState.Loading)
    Column(modifier) {
        (state as? BankListState.Loading)?.let {
            Text(text = "Authenticated. Loading bank list...")
        }
        (state as? BankListState.Content)?.let { safeState ->
            LazyColumn {
                items(
                    items = safeState.wallets,
                    key = { it.id },
                ) { wallet ->
                    WalletCard(wallet = wallet)
                }
            }
        }
        Text(text = "Authenticated.", modifier = Modifier.padding(top = 32.dp))
        Button(onClick = {
            scope.launch {
                Firebase.auth.signOut()
            }
        }) {
            Text(text = "Sign out")
        }
    }
}

@Composable
fun WalletCard(
    modifier: Modifier = Modifier,
    wallet: Wallet,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = wallet.name)
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = wallet.currentValue.toString(),
            )
        }
    }
}

@Preview
@Composable
private fun PreviewWalletCard2() {
    val wallet = Wallet("a", "LeConta", 10, true)
    AppCompatTheme {
        WalletCard(wallet = wallet)
    }
}
