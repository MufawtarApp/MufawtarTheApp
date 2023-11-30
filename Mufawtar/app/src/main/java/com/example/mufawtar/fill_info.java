package com.example.mufawtar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.*;
public class fill_info extends AppCompatActivity {
    private ImageView imageView;
    private Uri imageUri;
    private Bitmap pic;
    private Bundle b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_info);

        Intent intent = getIntent();
        String imageUriString = intent.getStringExtra("image");
        imageUri = Uri.parse(imageUriString);
        imageView = findViewById(R.id.imageView); // Replace with your actual ImageView ID
        imageView.setImageURI(imageUri);
    }
}
