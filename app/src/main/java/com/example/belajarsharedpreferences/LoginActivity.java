package com.example.belajarsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String tempUsername, tempPassword;
    KendaliLogin KL = new KendaliLogin(LoginActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tempUsername = etUsername.getText().toString();
                tempPassword = etPassword.getText().toString();

                if (tempUsername.trim().equals("")) {
                    etPassword.setError("password tidak boleh kosong");
                } else if (tempPassword.trim().equals("")) {
                    etPassword.setError("Password tidak boleh kosong");
                } else {
                    if (tempUsername.equals(KL.varUsername1) && tempPassword.equals(KL.varPassword1)) {
                        KL.setPref(KL.keyUsername, KL.varUsername1);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else if (tempUsername.equals(KL.varUsername2) && tempPassword.equals(KL.varPassword2)) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "username atau password salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}