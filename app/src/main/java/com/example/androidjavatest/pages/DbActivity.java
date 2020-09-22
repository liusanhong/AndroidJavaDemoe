package com.example.androidjavatest.pages;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidjavatest.R;
import com.example.androidjavatest.db.MyDataBaseHelper;

/**
 * 数据库的测试
 * TODO 数据库有问题，没管了
 */
public class DbActivity extends AppCompatActivity {
    private MyDataBaseHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        dbHelper = new MyDataBaseHelper(this,"BookStore.db",null,2);
        findViewById(R.id.create_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = dbHelper.getReadableDatabase();
            }
        });

        findViewById(R.id.create_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("author","lq");
                values.put("price",15.50);
                values.put("pages",300);
                values.put("name","book1");
                db.insert("BOOK",null,values);

                ContentValues valuesCategory = new ContentValues();
                valuesCategory.put("category_name","category1");
                valuesCategory.put("category_code",2);

                db.insert("Category",null,valuesCategory);
            }
        });

    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,DbActivity.class);
        context.startActivity(intent);
    }



}
