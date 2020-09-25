package com.example.androidjavatest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.androidjavatest.broadcast.MyBroadcastReceiver;
import com.example.androidjavatest.pages.DbActivity;
import com.example.androidjavatest.pages.ListViewDemo;
import com.example.androidjavatest.pages.MultimediaActivity;
import com.example.androidjavatest.pages.NewsActivity;
import com.example.androidjavatest.pages.RecyclerViewDemo;
import com.example.androidjavatest.pages.SaveActivity;

public class MainActivity extends AppCompatActivity {
    LocalBroadcastManager localBroadcastManager;
    private MyBroadcastReceiver myBroadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        隐藏头部
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!= null){
            actionBar.hide();
        }

        findViewById(R.id.list_view_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListViewDemo.actionStart(MainActivity.this);
            }
        });
        findViewById(R.id.recycler_view_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerViewDemo.actionStart(MainActivity.this);
            }
        });

        findViewById(R.id.news_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsActivity.actionStart(MainActivity.this);
            }
        });
        localBroadcastManager = LocalBroadcastManager.getInstance(MainActivity.this);

        findViewById(R.id.broadcast_commend_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("MyBroadcastReceiver","MyBroadcastReceiver onClick");

                Intent intent = new Intent();
                intent.setAction("cn.programmer.CUSTOM_INTENT"); //todo 为什么无效？？？？？
//                通过制定发送
//                intent.setComponent(new ComponentName("com.example.androidjavatest","com.example.androidjavatest.broadcast.MyBroadcastReceiver"));
//                sendBroadcast(intent);
                localBroadcastManager.sendBroadcast(intent);
            }
        });
//        本地发送广播，不会广播到程序外
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("cn.programmer.CUSTOM_INTENT");
        localBroadcastManager.registerReceiver(myBroadcastReceiver,intentFilter);



        findViewById(R.id.save_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveActivity.actionStart(MainActivity.this);
            }
        });

        findViewById(R.id.save_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbActivity.actionStart(MainActivity.this);
            }
        });
        findViewById(R.id.multimedia_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultimediaActivity.actionStart(MainActivity.this);
            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myBroadcastReceiver);
    }
}