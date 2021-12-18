package com.example.appauthen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import java.sql.DatabaseMetaData;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ProgressDialog loader;
    private Button btn_register;
    private EditText edt_email;
    private EditText edt_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);

        btn_register = findViewById(R.id.btnRegister);
        edt_email = findViewById(R.id.emailRegister);
        edt_pass = findViewById(R.id.passRegister);

        addListener();
    }

    private void addListener() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_email.getText().toString().trim();
                String password = edt_pass.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    edt_email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    edt_pass.setError("Password is required");
                    return;
                } else {
                    loader.setMessage("Register in progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();

                    mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                gotoLoginActivity();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(RegisterActivity.this, "Login failed" + error, Toast.LENGTH_SHORT).show();

                            }
                            loader.dismiss();
                        }
                    });

                }
            }
        });

    }
    private void gotoLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}


