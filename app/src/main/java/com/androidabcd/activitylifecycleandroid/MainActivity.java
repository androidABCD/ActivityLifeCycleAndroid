package com.androidabcd.activitylifecycleandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify("onCreate()","activity is first created.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notify("onStart()","activity is becoming visible to the user.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume()","activity will start interacting with the user.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause()","activity is not visible to the user.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop()","called when activity is no longer visible to the user.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notify("onRestart()","called after your activity is stopped, prior to start.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("onDestroy()","called before the activity is destroyed.");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        notify("onBackPressed()","called when back button pressed.");
    }



    private void notify(String methodName, String ContentText) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
                .setContentTitle(methodName)// + " " + strings[strings.length - 1]).setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(ContentText).build();//(strings[strings.length - 1]).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }
}
