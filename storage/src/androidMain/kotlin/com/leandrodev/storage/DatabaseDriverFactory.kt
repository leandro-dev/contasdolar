package com.leandrodev.storage

import android.content.Context
import com.leandrodev.expenses.Expenses
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver


actual class DatabaseDriverFactory(
    private val context: Context,
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Expenses.Schema, context, "expenses.db")
    }
}