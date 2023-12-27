package com.kawatrainingcenter.zanzibarnature.data.kawaApi.helper

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

    val getFavouriteIds: Flow<Set<Int>> = context.dataStore.data.map { preferences ->
        preferences[FAV_LIST]?.map { it.toInt() }?.toSet() ?: setOf()
    }

    suspend fun saveId(id: Int) {
        context.dataStore.edit { preferences ->
            val ids = preferences[FAV_LIST]?.toMutableSet() ?: mutableSetOf()
            if(ids.contains(id.toString())) {
                ids.remove(id.toString())
            } else {
                ids.add(id.toString())
            }
            preferences[FAV_LIST] = ids
        }
    }
}