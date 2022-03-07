package com.leandrodev.contasdolar

import com.leandrodev.contasdolar.android.auth.AuthViewModel
import com.leandrodev.contasdolar.android.auth.authModule
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import kotlin.test.assertNotNull


class AuthDependenciesTest : KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // TODO Find and include the provided dependency that makes the following line to crash
//        printLogger()
        modules(authModule)
    }

    @Test
    fun `should inject authViewModel`() {
        val viewModel = get<AuthViewModel>()

        assertNotNull(viewModel)
    }
}