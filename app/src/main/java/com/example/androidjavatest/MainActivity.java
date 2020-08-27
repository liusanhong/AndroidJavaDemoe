package com.example.androidjavatest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidjavatest.pages.ListViewDemo;
import com.example.androidjavatest.pages.NewsActivity;
import com.example.androidjavatest.pages.RecyclerViewDemo;

public class MainActivity extends AppCompatActivity {

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


    }
}