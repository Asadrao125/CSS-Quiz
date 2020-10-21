package com.example.cssquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btn_create_account, btn_login;
    EditText edt_number, edt_password;
    TextView forget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        listeners();

    }

    private void listeners() {
        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        btn_create_account = findViewById(R.id.btn_create_account);
        btn_login = findViewById(R.id.btn_login);
        edt_number = findViewById(R.id.edt_number);
        edt_password = findViewById(R.id.edt_password);
        forget_password = findViewById(R.id.tv_forget_password);
    }
}