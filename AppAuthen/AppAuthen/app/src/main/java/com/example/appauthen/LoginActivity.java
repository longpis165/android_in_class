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


public class LoginActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtPass;
    private Button btnLogin;
    private Button btnNewAcc;
    private FirebaseAuth mAuth;
    private ProgressDialog loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtName = findViewById(R.id.emailLogin);
        edtPass = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.button_login);
        btnNewAcc = findViewById(R.id.btn_newAcc);

        mAuth =FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);
        addListener();

    }

    private void addListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtName.getText().toString().trim();
                String password  = edtPass.getText().toString().trim();
                if(TextUtils.isEmpty(username)){
                    edtName.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    edtPass.setError("Password is required");
                    return;
                } else {
                    loader.setMessage("Login in progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();

                    mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                gotoMainActivity();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(LoginActivity.this, "Login failed"+ error, Toast.LENGTH_SHORT).show();

                            }
                            loader.dismiss();
                        }
                    });

                }

            }
        });
        btnNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRegisterActivity();
                finish();
            }
        });

    }
    private void gotoMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainUserActivity.class);
        startActivity(intent);
        finish();
    }
    private void gotoRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}