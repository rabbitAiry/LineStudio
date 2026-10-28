package com.airy.linestudio.source.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.linestudio.repository.data.PidsStyle
import com.airy.linestudio.source.preference.data.SelectedLineData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceSource @Inject constructor(
    @ApplicationContext val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "main_data")
    private val dataStore = context.dataStore

    private val keySelectedLine = stringPreferencesKey("SelectedLine")
    private val keySelectedStyle = intPreferencesKey("SelectedStyle")
    private val keyEnableGeofencing = booleanPreferencesKey("EnableGeofencing")

    suspend fun setGeofencing(enable: Boolean) = write(keyEnableGeofencing, enable)
    suspend fun getGeofencing() = get(keyEnableGeofencing).first() ?: true

    suspend fun getLastSelected() = SelectedLineData(
        get(keySelectedLine).first(),
        get(keySelectedStyle).first()?.let { PidsStyle.entries[it] },
    )

    suspend fun saveLastSelected(lineMap: LineMap?, line: Line, pidsStyle: PidsStyle){
        dataStore.edit { settings ->
            settings[keySelectedLine] = if (lineMap!=null) "${lineMap.name}/${line.name}" else line.name
            settings[keySelectedStyle] = pidsStyle.ordinal
        }
    }

    private fun <T> get(key: Preferences.Key<T>) =
        dataStore.data.map { preferences -> preferences[key] }

    private suspend fun <T> write(key: Preferences.Key<T>, value: T) {
        dataStore.edit { settings -> settings[key] = value }
    }
}