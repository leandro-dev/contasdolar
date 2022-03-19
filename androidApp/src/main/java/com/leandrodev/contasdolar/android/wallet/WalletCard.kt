package com.leandrodev.contasdolar.android.wallet

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.leandrodev.contasdolar.android.R
import com.leandrodev.contasdolar.android.ui.MoneyText
import com.leandrodev.contasdolar.android.ui.theme.HomeTheme
import com.leandrodev.storage.model.Wallet

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

@Preview(widthDp = 400, heightDp = 200)
@Composable
private fun PreviewWalletCard() {
    val wallet = Wallet("a", "LeConta", 10, true, "")
    HomeTheme {
        WalletCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            wallet = wallet,
        )
    }
}
