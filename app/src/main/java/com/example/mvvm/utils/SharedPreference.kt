package com.example.mvvm.utils

import android.content.Context

class SharedPreference(context: Context) {
    private val APP_PREF_NAME = "App"
    private val preference = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)

    var userToken: String?
        get() = preference.getString("TOKEN", null)
        set(value) = preference.edit().putString("TOKEN", value).apply()
}