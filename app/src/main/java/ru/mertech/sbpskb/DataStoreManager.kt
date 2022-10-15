package ru.mertech.sbpskb

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.SharedPreferencesMigration
import kotlinx.coroutines.flow.catch

class DataStoreManager(private val context: Context) {

    suspend fun setBank(selectedItem: Int) {
        context.dataStore.edit { preferences ->
            preferences[SELECTED_BANK_KEY] = selectedItem
        }
    }

    val selectedItem: Flow<Int>
        get() = context.dataStore.data.map { preferences ->
            preferences[SELECTED_BANK_KEY] ?: 0
        }

    suspend fun setDate(date: String) {
        context.dataStore.edit { preferences ->
            preferences[DATE_KEY] = date
        }
    }

    val date: Flow<String>
        get() = context.dataStore.data.catch { exception ->
            if (exception is java.io.IOException) {
                emit(androidx.datastore.preferences.core.emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[DATE_KEY] ?: ""

        }


    companion object {
        private const val DATASTORE_NAME = "app_preferences"

        private val SELECTED_BANK_KEY = intPreferencesKey("selected_bank_key")
        private val DATE_KEY = stringPreferencesKey("date_key")

        private val Context.dataStore by preferencesDataStore(
            name = DATASTORE_NAME
        )

    }
}