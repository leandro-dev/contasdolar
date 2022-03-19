package com.leandrodev.contasdolar.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.leandrodev.contasdolar.android.auth.state.AuthStateScreen
import com.leandrodev.contasdolar.android.ui.theme.HomeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = findViewById<ComposeView>(R.id.auth)

        auth.setContent {
            HomeTheme {
                AuthStateScreen(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.background
                        )
                        .fillMaxSize()
                )
            }
        }
    }
}
