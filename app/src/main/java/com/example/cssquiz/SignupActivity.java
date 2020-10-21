package com.example.cssquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class SignupActivity extends AppCompatActivity {
    EditText edt_name, edt_number, edt_password, edt_email;
    Button btn_signup;
    String number, name, password, email;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = edt_number.getText().toString().trim();
                name = edt_name.getText().toString().trim();
                password = edt_password.getText().toString().trim();
                email = edt_email.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Users");
                            UserModel userModel = new UserModel(id, name, email, number, password);
                            mRef.child(id).setValue(userModel);
                            Toast.makeText(SignupActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();

                        } else {
                            String message = task.getException().getMessage();
                            Toast.makeText(getApplicationContext(), "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void init() {
        edt_name = findViewById(R.id.edt_name);
        edt_number = findViewById(R.id.edt_number);
        edt_password = findViewById(R.id.edt_password);
        btn_signup = findViewById(R.id.btn_signup);
        mAuth = FirebaseAuth.getInstance();
        edt_email = findViewById(R.id.edt_email);
    }
}