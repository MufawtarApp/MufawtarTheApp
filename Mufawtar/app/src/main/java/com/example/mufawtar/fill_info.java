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
import java.io.InputStream;
import java.io.IOException;

public class fill_info extends AppCompatActivity {
    private ImageView imageView;
    private Uri imageUri;
    private Bitmap pic;
    private Bundle b1;
    private EditText invoicDescripion  ;
    private Button add;

    private Invoice inv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_info);

        Intent intent = getIntent();
        String imageUriString = intent.getStringExtra("image");
        imageUri = Uri.parse(imageUriString);
        imageView = findViewById(R.id.imageView);

        // Convert URI to Bitmap
        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            pic = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(pic);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading image", Toast.LENGTH_SHORT).show();
        }
        invoicDescripion = findViewById(R.id.editTextTextMultiLine);
        add = findViewById(R.id.button);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String invDes = invoicDescripion.getText().toString();
                if(invDes.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Pleas enter invoice description " , Toast.LENGTH_LONG).show();
                }else {
                    inv = new Invoice(invDes,pic);
                    invoices.list.add(inv);
                    Toast.makeText(getApplicationContext(), "Image is added " + invDes, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), invoices.class);
                    startActivity(intent);
                }
            }
        });
    }
}
