package edu.coe.richmond.simplewidget

import android.content.Context
import android.util.Log

class SavePref {
    companion object {
        val PREFS_NAME = "edu.coe.richmond.simpleWidget.RandomWidget"
        val PREF_PREFIX_KEY = "appwidget_"
        val LOGKEY = "Prefs"

        @JvmStatic
        fun savePref(context: Context, appWidgetId: Int, title: String) {
            val titlePrefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
            titlePrefs.putString(PREF_PREFIX_KEY + appWidgetId, title)
            Log.i(LOGKEY, title)
            titlePrefs.apply()
        }

        @JvmStatic
        fun loadTitle(context: Context, appWidgetId: Int): String? {
            val titlePrefs = context.getSharedPreferences(PREFS_NAME, 0)
            val titleValue = titlePrefs.getString(PREF_PREFIX_KEY + appWidgetId, "EXAMPLE")
            if (titleValue != null) {
                Log.i(LOGKEY, titleValue)
            }
            return titleValue
        }
        @JvmStatic
        fun loadMessage(context: Context, appWidgetId: Int): String? {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0)
            val messageValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, "EXAMPLE")
            if (messageValue != null) {
                Log.i(LOGKEY, messageValue)
            }
            return messageValue
        }
        @JvmStatic
        fun loadPhone(context: Context, appWidgetId: Int): String? {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0)
            val phoneValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, "EXAMPLE")
            if (phoneValue != null) {
                Log.i(LOGKEY, phoneValue)
            }
            return phoneValue
        }
        @JvmStatic
        fun deleteTitlePref(context: Context, appWidgetId: Int) {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
            prefs.remove(PREF_PREFIX_KEY + appWidgetId)
            prefs.apply()
        }
    }
}