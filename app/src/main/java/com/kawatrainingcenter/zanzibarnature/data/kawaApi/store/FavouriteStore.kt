package com.kawatrainingcenter.zanzibarnature.data.kawaApi.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouriteStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("fav")
        private val FAV_LIST = stringSetPreferencesKey("fav_list")
    }

    val getFavouriteIds: Flow<Set<String>> = context.dataStore.data.map { preferences ->
        preferences[FAV_LIST]?.map { it }?.toSet() ?: setOf()
    }

    suspend fun saveId(id: String) {
        context.dataStore.edit { preferences ->
            val ids = preferences[FAV_LIST]?.toMutableSet() ?: mutableSetOf()
            if(ids.contains(id)) {
                ids.remove(id)
            } else {
                ids.add(id)
            }
            preferences[FAV_LIST] = ids
        }
    }
}