package org.sopt.androidassignment1.data

import android.content.Context
import android.content.SharedPreferences

object SOPTSharedPreferences {
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    fun getAutoLogin(context: Context): Boolean = getPreference(context).getBoolean(AUTO_LOGIN, false)


    fun setAutoLogin(context: Context, value: Boolean) {
        getPreference(context).edit()
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun removeAutoLogin(context: Context) {
        getPreference(context).edit()
            .remove(AUTO_LOGIN)
            .apply()
    }

    fun clearStorage(context: Context) {
        getPreference(context).edit()
            .clear()
            .apply()
    }

    private fun getPreference(context: Context) = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
}