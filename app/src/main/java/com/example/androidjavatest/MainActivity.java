package com.example.androidjavatest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
//                Intent intent = new Intent(MainActivity.this,ListViewDemo.class);
//                startActivity(intent);
                ListViewDemo.actionStart(MainActivity.this);
            }
        });


    }
}