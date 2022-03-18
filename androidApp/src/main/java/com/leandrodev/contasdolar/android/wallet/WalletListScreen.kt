package com.leandrodev.contasdolar.android.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.leandrodev.storage.model.Wallet
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun WalletListScreen(
    modifier: Modifier = Modifier,
    viewModel: WalletListViewModel = getViewModel()
) {
    val scope = rememberCoroutineScope()
    val state: WalletListState by viewModel.state.collectAsState(initial = WalletListState.Loading)
    Column(modifier) {
        (state as? WalletListState.Loading)?.let {
            Text(text = "Authenticated. Loading bank list...")
        }
        (state as? WalletListState.Content)?.let { safeState ->
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
        ConstraintLayout(
            modifier = Modifier.padding(8.dp)
        ) {
            val (image, title, balance) = createRefs()
            AsyncImage(
                modifier = Modifier.size(30.dp).constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                },
                model = wallet.imageUrl,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, margin = 8.dp)
                    width = Dimension.preferredWrapContent
                    height = Dimension.preferredWrapContent
                },
                text = wallet.name
            )
            Text(
                modifier = Modifier.constrainAs(balance) {
                    top.linkTo(title.bottom, margin = 8.dp)
                    start.linkTo(title.start)
                    width = Dimension.preferredWrapContent
                    height = Dimension.preferredWrapContent
                },
                text = wallet.currentValue.toString(),
            )
        }
    }
}

@Preview(widthDp = 800, heightDp = 200)
@Composable
private fun PreviewWalletCard() {
    val wallet = Wallet("a", "LeConta", 10, true,
        "https://play-lh.googleusercontent.com/aFWiT2lTa9CYBpyPjfgfNHd0r5puwKRGj2rHpdPTNrz2N9LXgN_MbLjePd1OTc0E8Rl1=s180-rw"
    )
    AppCompatTheme {
        WalletCard(wallet = wallet)
    }
}
