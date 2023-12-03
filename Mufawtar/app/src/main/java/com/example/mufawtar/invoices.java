package com.example.mufawtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class invoices extends AppCompatActivity {
    public static ArrayList<Invoice> list = new ArrayList<>();
    ListView listView;
    private ImageButton logout;
    private ImageButton homePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_invoices);
        listView = (ListView) findViewById(R.id.list);
        custmBaseAdabtere custmBaseAdabtere = new custmBaseAdabtere(getApplicationContext(),list);
        listView.setAdapter(custmBaseAdabtere);

        //call logout
        logout = findViewById(R.id.logout2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        homePage = findViewById(R.id.homepage2);

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(intent);
            }
        });
    }
}
