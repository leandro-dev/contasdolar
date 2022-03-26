package com.leandrodev.auth

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.leandrodev.auth.signin.AuthScreen
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class AuthScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    companion object {
        @BeforeClass @JvmStatic
        fun setUp() {
            Firebase.auth.android.signOut()
        }
    }

    @Test
    fun givenInitialState_shouldShowGoogleAuthOption() {
        composeTestRule.setContent { AuthScreen() }

        composeTestRule
            .onNodeWithText("Hello")
            .assertIsDisplayed()
    }

    @Test
    fun givenInitialState_whenSignInWithGoogle_shouldNavigateToNextScreen() {
        TODO("Implement test validating navigation")
    }
}