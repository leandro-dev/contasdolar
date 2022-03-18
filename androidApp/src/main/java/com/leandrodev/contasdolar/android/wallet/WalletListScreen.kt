package com.leandrodev.contasdolar.android.wallet

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.leandrodev.contasdolar.android.R
import com.leandrodev.storage.model.Wallet
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import java.text.NumberFormat
import java.util.*

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
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(all = 8.dp),
            ) {
                items(
                    items = safeState.wallets,
                    key = { it.id },
                ) { wallet ->
                    WalletCard(
                        modifier = Modifier.fillMaxWidth(),
                        wallet = wallet,
                    )
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
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 16.dp))
                    .size(65.dp)
                    .border(width = 50.dp, color = Color.Transparent)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    },
                model = wallet.imageUrl,
                placeholder = painterResource(id = R.drawable.money_bag),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, margin = 8.dp)
                    width = Dimension.preferredWrapContent
                    height = Dimension.wrapContent
                },
                style = MaterialTheme.typography.h5,
                text = wallet.name,
            )
            MoneyText(
                modifier = Modifier.constrainAs(balance) {
                    top.linkTo(title.bottom, margin = 8.dp)
                    start.linkTo(image.end, margin = 8.dp)
                    width = Dimension.preferredWrapContent
                    height = Dimension.wrapContent
                },
                style = MaterialTheme.typography.subtitle1,
                value = wallet.currentValue,
            )
        }
    }
}

@Composable
fun MoneyText(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    value: Long,
) {
    val locale = Locale("pt", "BR")
    val format = NumberFormat.getCurrencyInstance(locale)
    format.maximumFractionDigits = 2
    val formattedText = format.format(value)

    Text(
        modifier = modifier,
        style = style,
        text = formattedText,
    )
}

@Preview(widthDp = 400, heightDp = 200)
@Composable
private fun PreviewWalletCard() {
    val wallet = Wallet("a", "LeConta", 10, true, "")
    AppCompatTheme {
        WalletCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            wallet = wallet,
        )
    }
}
