package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    ImageView imgBack;
    TextView signIn;
    Button btnSignUp;
    EditText email, password, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        backFrame();
        changFrameSignUp();
        handleSignUp();
    }
    public void backFrame() {
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, HomeLogin.class);
                startActivity(intent);
            }
        });
    }

    public void changFrameSignUp(){
        signIn = (TextView) findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    public void handleSignUp() {
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        email = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);
        confirmPassword = (EditText) findViewById(R.id.editTextPasswordConfirm);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((email.getText().toString().trim().equals("admin"))){
                    Toast.makeText(SignUp.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                }else{
                    if(!password.getText().toString().trim().equals(confirmPassword.getText().toString().trim())){
                        Toast.makeText(SignUp.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignUp.this, "Tạo tài khoản thành công, vui lòng chọn đăng nhập để đăng nhập tài khoản", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}