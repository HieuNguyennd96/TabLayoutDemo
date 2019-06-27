package com.example.dotslidingtabdemo.util

import android.content.Context
import android.content.SharedPreferences
import com.example.dotslidingtabdemo.base.IS_FIRST_TIME
import com.example.dotslidingtabdemo.base.PREFERENCE_NAME

class SharePreference(context:Context) {
    private val preference: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preference.edit()

    var isFirstTime: Boolean
        get() = preference.getBoolean(IS_FIRST_TIME,true)
        set(value) {
            editor.putBoolean(IS_FIRST_TIME,value)
            editor.commit()
        }

}