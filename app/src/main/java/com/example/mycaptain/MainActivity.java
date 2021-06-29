package com.example.mycaptain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);

    }

    public  void signup(View v)
    {
        if(password.getText().toString().length()>=8 && validatepassword(password.getText().toString()))
        {

            Toast.makeText(this, "succesful", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Signin.class);
            Bundle b=new Bundle();
            b.putString("uid",username.getText().toString());
            b.putString("password",password.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "password not meeting constraints", Toast.LENGTH_LONG).show();
        }
    }
public boolean validatepassword(String password)
{
    Pattern patrn;
    Matcher mat;
    String pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    patrn=Pattern.compile(pattern);
    mat=patrn.matcher(password);
    return mat.matches();

}



}