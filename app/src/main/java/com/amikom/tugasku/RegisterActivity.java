package com.amikom.tugasku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amikom.tugasku.helper.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button  register;
    EditText username, password, passwordConf;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.edtText_usernameRegist);
        password = (EditText)findViewById(R.id.edtText_passwordRegist);
        passwordConf = (EditText)findViewById(R.id.edtText_passwordConfRegist);
        login = (TextView) findViewById(R.id.loginRegist);
        register = (Button)findViewById(R.id.btn_registerRegist);

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity2.class);
                startActivity(loginIntent);
                finish();
            }
        });

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordConf = passwordConf.getText().toString();
                if (strPassword.equals(strPasswordConf)) {
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if (daftar == true) {
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity2.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
