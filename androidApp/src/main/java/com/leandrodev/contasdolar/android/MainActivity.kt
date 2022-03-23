package com.leandrodev.contasdolar.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.leandrodev.contasdolar.android.auth.state.AuthStateScreen
import com.leandrodev.contasdolar.android.ui.theme.HomeTheme
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI

class MainActivity : ComponentActivity(), DIAware {
    override val di: DI by closestDI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeTheme {
                AuthStateScreen()
            }
        }
    }
}
