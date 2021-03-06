package edu.coe.richmond.simplewidget

import android.Manifest
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class WidgetConfigure : AppCompatActivity(), View.OnClickListener {
    var mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID

    /** Called when the activity is first created.  */
    override fun onCreate(savedInstanceState: Bundle?) {
        val REQUEST_SEND_SMS = 123
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
            !== PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS,Manifest.permission.READ_PHONE_STATE),
                REQUEST_SEND_SMS)
        }
        super.onCreate(savedInstanceState)

        // Find the widget id from the intent.
        val intent: Intent = getIntent()
        val extras = intent.extras
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
        }
        setContentView(R.layout.configure_layout)
        findViewById<Button>(R.id.btnSave).setOnClickListener(this)
    }


    override fun onClick(v: View) {
        val context: Context = this@WidgetConfigure

        // Push widget update to surface with newly set prefix
        val appWidgetManager = AppWidgetManager.getInstance(context)
        // RandomWidget.updateTitle(context, appWidgetManager, mAppWidgetId, "");
        val title = findViewById<EditText>(R.id.recipText).text.toString()
        val message = findViewById<EditText>(R.id.editTextMessage).text.toString()
        val phoneNumber = findViewById<EditText>(R.id.editTextPhone).text.toString()
        SavePref.savePref(context, mAppWidgetId, title, message, phoneNumber)
        // Make sure we pass back the original appWidgetId
        val resultValue = Intent()
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId)
        setResult(RESULT_OK, resultValue)

        finish()
    }
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun onButtonClick() {

    }
}