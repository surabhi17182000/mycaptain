package com.example.mycaptain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);

    }

    public void signin(View v){
        Bundle b=getIntent().getExtras();
        String uname=b.getString("uid");
        String passwd=b.getString("password");
        if(username.getText().toString().equals(uname) && password.getText().toString().equals(passwd))
        {

            Toast.makeText(this, "succesful", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Success.class);
        }
        else
        {
            Toast.makeText(this, "password not meeting constraints", Toast.LENGTH_LONG).show();
        }
    }
}