package edu.coe.richmond.simplewidget


import android.Manifest
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import android.widget.RemoteViews
import java.util.*
import android.telephony.SmsManager
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity


class RandomWidget : AppWidgetProvider() {

    var random = Random()
    var nums: String? = null
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager, appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (appWidget in appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidget)

        }
    }

        //fun onCreate(savedInstanceState: Bundle?) {
        //  val REQUEST_SEND_SMS = 123

        //}

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        fun onClick(v: View) {

            /*val defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this) // Need to change the build to API 19
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.type = "text/plain"
            sendIntent.putExtra(Intent.EXTRA_TEXT, "text")
            if (defaultSmsPackageName != null) // Can be null in case that there is no default, then the user would be able to choose
            // any app that support this intent.
            {
                sendIntent.setPackage(defaultSmsPackageName)
            }
            ContextCompat.startActivity(this, sendIntent, null)*/
        }

        fun updateWidget(
            context: Context,
            appWidgetManager: AppWidgetManager, appWidgetId: Int
        ) {

            var SMSmgr: SmsManager = SmsManager.getDefault();
            SMSmgr!!.sendTextMessage("5544", null, "oi", null, null);
            //val r1 = random.nextInt(10)
            //val r2 = random.nextInt(10)
            //val r3 = random.nextInt(10)
            //val nums = "$r1 $r2 $r3"
            val title = "Pick 3"

            val updateViews = RemoteViews(
                context.packageName, R.layout.widget_layout
            )
            //updateViews.setTextViewText(R.id.text, title)
            //updateViews.setTextViewText(R.id.numbers, nums)

            //Setup the Intent to click on the widget to update.
            val intentUpdate = Intent(context, RandomWidget::class.java)
            intentUpdate.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE

            val idArray = intArrayOf(appWidgetId)
            intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
            val pendingUpdate = PendingIntent.getBroadcast(
                context, appWidgetId, intentUpdate,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            updateViews.setOnClickPendingIntent(R.id.wholeWidget, pendingUpdate);


            appWidgetManager.updateAppWidget(appWidgetId, updateViews)
        }

}



