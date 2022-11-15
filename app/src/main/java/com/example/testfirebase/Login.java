package com.example.testfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText emailEdit, passEdit;
    private Button loginBtn, registerBtn;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEdit = findViewById(R.id.editTextEmail);
        passEdit = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.btnSignIn);
        registerBtn = findViewById(R.id.btnSignUp);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        //lay gia tri
        emailEdit.setText(sharedPreferences.getString("taikhoan", ""));
        passEdit.setText(sharedPreferences.getString("matkhau", ""));

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSignIn();
            }
        });


    }

    private void register() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    public void handleSignIn() {
        loginBtn = (Button) findViewById(R.id.btnSignIn);
        emailEdit = (EditText) findViewById(R.id.editTextEmail);
        passEdit = (EditText) findViewById(R.id.editTextPassword);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((emailEdit.getText().toString().trim().equals("admin@gmail.com") || emailEdit.getText().toString().trim().equals("viettruong0825@gmail.com"))
                        && (passEdit.getText().toString().trim().equals("123456") || passEdit.getText().toString().trim().equals("1234567"))){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}