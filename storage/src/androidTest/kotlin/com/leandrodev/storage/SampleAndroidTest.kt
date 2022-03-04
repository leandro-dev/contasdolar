package com.leandrodev.storage

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import kotlin.test.*

@RunWith(AndroidJUnit4::class)
class SampleAndroidTest {
    private fun createDatabase() = Database(DatabaseDriverFactory(ApplicationProvider.getApplicationContext()))

    @Test
    fun givenEmptyDatabase_whenInsertWalletAndCheckList_shouldContainWallet() {
        val database = createDatabase()
        database.clearDatabase()
        database.createWallet("Test")
        val wallets = database.getAllWallets()
        assertContains(wallets.map { it.name }, "Test")
    }

    @Test
    fun givenEmptyDatabase_whenInsertWalletAndCheckResult_shouldContainWalletWithDefaultValues() {
        val database = createDatabase()
        database.clearDatabase()
        database.createWallet("Test")
        val wallet = requireNotNull(database.getWallet("Test"))
        assertEquals(wallet.name, "Test")
        assertEquals(wallet.current_value, 0L)
        assertEquals(wallet.active, true)
    }
}