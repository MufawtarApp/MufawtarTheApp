package com.example.mufawtar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.usernameBox);
        password = findViewById(R.id.passwordBox);
        repassword = findViewById(R.id.rePasswordBox);
        signup = findViewById(R.id.signUpButton);
        DB = DBHelper.getInstance(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)) {
                    Toast.makeText(signUp.this, "All fields Required", Toast.LENGTH_SHORT).show();
                } else if (!isPasswordComplex(pass)) {
                    Toast.makeText(signUp.this, "Password must include numbers, letters, upper and lower case, and be at least 8 characters long", Toast.LENGTH_LONG).show();
                } else if (!pass.equals(repass)) {
                    Toast.makeText(signUp.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuser = DB.checkusernane(user);
                    if (!checkuser) {
                        Boolean insert = DB.insertData(user, pass);
                        if (insert) {
                            Toast.makeText(signUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(signUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(signUp.this, "User already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean isPasswordComplex(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return password.matches(pattern);
    }
}
