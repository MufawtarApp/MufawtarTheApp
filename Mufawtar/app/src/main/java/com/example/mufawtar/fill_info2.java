package com.example.mufawtar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class fill_info2 extends AppCompatActivity {
    private ImageView imageView;
    private Bitmap pic;
    private Bundle b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_info);

        Intent intent = getIntent();
        byte[] byteArray = getIntent().getByteArrayExtra("image2");
        pic = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(pic);
    }
}
