package com.example.androidjavatest.pages;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.androidjavatest.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MultimediaActivity extends AppCompatActivity {

    File outputImage;
    private Uri imageUri;
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        picture = findViewById(R.id.picture);

        findViewById(R.id.take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }

                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(Build.VERSION.SDK_INT>24){
                    imageUri = FileProvider.getUriForFile(MultimediaActivity.this, "com.example.androidjavatest.fileprovider", outputImage);

                }else {
                    imageUri = Uri.fromFile(outputImage);
                }

                //启动相机
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,1);
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MultimediaActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}