package com.leandrodev.storage

import com.leandrodev.expenses.Expenses
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver


actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Expenses.Schema, "expenses.db")
    }
}