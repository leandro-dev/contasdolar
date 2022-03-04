package com.leandrodev.contasdolar.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.google.accompanist.appcompattheme.AppCompatTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = findViewById<ComposeView>(R.id.auth)

        auth.setContent {
            AppCompatTheme {
                AuthScreen(
                    onGoogleAuthClick = {}
                )
            }
        }
    }
}
