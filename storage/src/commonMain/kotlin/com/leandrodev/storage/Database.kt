package com.leandrodev.storage

import com.leandrodev.expenses.Expenses
import com.leandrodev.expenses.WalletQsldelight

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Expenses(databaseDriverFactory.createDriver())
    private val dbQuery = database.expensesQueries

    internal fun clearDatabase() {
        dbQuery.removeAllWallets()
    }

    internal fun getAllWallets(): List<WalletQsldelight> {
        return dbQuery.getWallets(::WalletQsldelight).executeAsList()
    }

    internal fun getWallet(name: String): WalletQsldelight? {
        return dbQuery.getWallet(name).executeAsOneOrNull()
    }

    internal fun createWallet(name: String) {
        dbQuery.createWallet(
            name = name,
            current_value = 0,
            active = true,
        )
    }
}