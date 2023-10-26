package com.example.loginregister;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class ActivityRegister extends AppCompatActivity{
    EditText etUser,etPwd,etRepwd;
    Button btnRegister, btnLogin;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUser = findViewById(R.id.etUsername);
        etPwd = findViewById(R.id.etPassword);
        etRepwd = findViewById(R.id.etRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        dbHelper = new DBHelper(this);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, pwd, rePwd;
                user = etUser.getText().toString();
                pwd = etPwd.getText().toString();
                rePwd = etRepwd.getText().toString();
                if (user.equals("") || pwd.equals("") || rePwd.equals("")){
                    Toast.makeText(ActivityRegister.this, "Silahkan isi semua", Toast.LENGTH_LONG).show();
                } else {
                    if(pwd.equals(rePwd)){
                        if(dbHelper.checkUsername(user)){
                            Toast.makeText(ActivityRegister.this, "User sudah ada", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean registeredSuccess = dbHelper.insertData(user,pwd);
                        if (registeredSuccess)
                            Toast.makeText(ActivityRegister.this, "Registrasi Sukses", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ActivityRegister.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(ActivityRegister.this, "Password salah", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
