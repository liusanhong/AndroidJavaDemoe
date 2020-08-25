package com.example.androidjavatest;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @Description: 自定义组件
 * @Author: LQ
 * @CreateDate: 2020/8/24 5:45 PM
 */
public class TitleLayout extends LinearLayout {

    public TitleLayout(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button back = (Button) findViewById(R.id.title_back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

        TextView titleText = (TextView) findViewById(R.id.title_text);

        Button titleEdit = (Button) findViewById(R.id.title_edit);
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Click Edit",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
