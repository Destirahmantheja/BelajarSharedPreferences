package com.example.belajarsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvUsername;
    private Button btnLogout;
    KendaliLogin KL = new KendaliLogin(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (KL.isLogin(KL.keyUsername) == true) {
            setContentView(R.layout.activity_main);

            tvUsername = findViewById(R.id.tv_username);
            btnLogout = findViewById(R.id.btn_logout);

            tvUsername.setText(KL.getPref(KL.keyUsername));
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(KL.keyUsername, null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });
        } else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}
