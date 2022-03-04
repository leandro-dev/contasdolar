package com.leandrodev.storage

import com.leandrodev.expenses.Expenses
import com.leandrodev.expenses.Wallet

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Expenses(databaseDriverFactory.createDriver())
    private val dbQuery = database.expensesQueries

    internal fun clearDatabase() {
        dbQuery.removeAllWallets()
    }

    internal fun getAllWallets(): List<Wallet> {
        return dbQuery.getWallets(::Wallet).executeAsList()
    }

    internal fun getWallet(name: String): Wallet? {
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