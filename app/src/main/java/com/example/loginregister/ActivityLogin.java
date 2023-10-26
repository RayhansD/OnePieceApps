package com.example.loginregister;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class ActivityLogin extends AppCompatActivity {
    DBHelper dbHelper;

    Button btnLogin;

    EditText etUsername, etPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DBHelper(this);
        etUsername = findViewById(R.id.etUsername);
        etPwd = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isLoggedid = dbHelper.checkUser(etUsername.getText().toString(), etPwd.getText().toString());
                if (isLoggedid){
                    Intent intent = new Intent(ActivityLogin.this, HomePage.class);
                    startActivity(intent);
                } else
                    Toast.makeText(ActivityLogin.this, "login gagal", Toast.LENGTH_LONG).show();
            }
        });

    }
}