package com.example.mufawtar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button signin;
    DBHelper DB;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernameBox1);
        password = findViewById(R.id.passwordBox1);
        signin = findViewById(R.id.signInButton1);
        signup = findViewById(R.id.signUpButton1);
        DB = DBHelper.getInstance(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Login Faild", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signUp.class);
                startActivity(intent);
            }
        });
    }
}