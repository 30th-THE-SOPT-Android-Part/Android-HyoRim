package org.sopt.android_hyorim_30th.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SOPTSharedPreference @Inject constructor(@ApplicationContext context: Context) {

    private val preference: SharedPreferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    var isAutoLogin: Boolean
        set(value) = preference.edit().putBoolean(IS_SAVE_ID, value).apply()
        get() = preference.getBoolean(IS_SAVE_ID, false)

    var userId: String
        set(value) = preference.edit().putString(USER_ID, value).apply()
        get() = preference.getString(USER_ID, "") ?: ""

    companion object {
        private const val IS_SAVE_ID = "IS_SAVE_ID"
        private const val USER_ID = "USER_ID"
    }
}
