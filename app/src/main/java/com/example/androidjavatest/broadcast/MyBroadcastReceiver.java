package com.example.androidjavatest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("MyBroadcastReceiver","MyBroadcastReceiver");
        Toast.makeText(context,"MyBroadcastReceiver",Toast.LENGTH_SHORT).show();
    }
}
