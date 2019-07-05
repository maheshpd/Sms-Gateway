package com.example.maheshprasad.mydishtv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    String username = "admin";
    String password = "password";
    EditText musername,mpassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        musername = findViewById(R.id.edt_email);
        mpassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musername.getText().toString().equals(username) && mpassword.getText().toString().equals(password))
                {
                    startActivity(new Intent(Login.this,HomeActivity.class));
                }else {
                    Toast.makeText(Login.this, "Please again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
