package edu.coe.richmond.simplewidget

import android.content.Context
import android.util.Log

class SavePref {
    companion object {
        val PREFS_NAME = "edu.coe.richmond.simpleWidget.RandomWidget"
        val PREF_PREFIX_KEY = "appwidget_"
        val LOGKEY = "Prefs"

        @JvmStatic
        fun savePref(context: Context, appWidgetId: Int, name: String, message: String, pn: String) {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
            prefs.putString("Name", name)
            prefs.putString("Message", message)
            prefs.putString("Phone", pn)
            Log.i(LOGKEY, message)
            Log.i(LOGKEY, pn)
            Log.i(LOGKEY, name)
            prefs.apply()
        }

        @JvmStatic
        fun loadName(context: Context, appWidgetId: Int): String? {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0)
            val titleValue = prefs.getString("Name", "EXAMPLE")
            if (titleValue != null) {
                Log.i(LOGKEY, titleValue)
            }
            return titleValue
        }
        @JvmStatic
        fun loadPN(context: Context, appWidgetId: Int): String? {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0)
            val phoneValue = prefs.getString("Phone", "EXAMPLE")
            if (phoneValue != null) {
                Log.i(LOGKEY, phoneValue)
            }
            return phoneValue
        }
        @JvmStatic
        fun loadMsg(context: Context, appWidgetId: Int): String? {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0)
            val msgValue = prefs.getString("Message", "EXAMPLE")
            if (msgValue != null) {
                Log.i(LOGKEY, msgValue)
            }
            return msgValue
        }

        @JvmStatic
        fun deleteTitlePref(context: Context, appWidgetId: Int) {
            val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
            prefs.remove(PREF_PREFIX_KEY + appWidgetId)
            prefs.apply()
        }
    }
}