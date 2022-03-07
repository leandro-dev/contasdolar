package com.leandrodev.contasdolar

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.leandrodev.contasdolar.android.auth.AuthScreen
import org.junit.Rule
import org.junit.Test

class AuthScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenInitialState_shouldShowGoogleAuthOption() {
        composeTestRule.setContent { AuthScreen() }

        composeTestRule
            .onNodeWithText("Hello")
            .assertIsDisplayed()
    }
}