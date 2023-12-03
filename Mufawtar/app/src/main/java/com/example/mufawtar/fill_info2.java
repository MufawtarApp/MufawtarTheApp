package com.example.mufawtar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class fill_info2 extends AppCompatActivity {
    private ImageView imageView;
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
        byte[] byteArray = getIntent().getByteArrayExtra("image2");
        pic = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(pic);
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
