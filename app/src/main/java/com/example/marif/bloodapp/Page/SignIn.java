package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marif.bloodapp.R;
import com.example.marif.bloodapp.Connectivity.signinConnectivity;

public class SignIn extends AppCompatActivity {


    TextView textview;
    EditText UserName;
    EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        textview = (TextView) findViewById(R.id.textView6);



    }

    public void login(){
        UserName=(EditText)findViewById(R.id.email_input_signin);
        Password=(EditText)findViewById(R.id.password_input_signin);
        new signinConnectivity(this,textview,UserName.getText().toString(),Password.getText().toString(), 0).execute();

    }
    public void goToHomeAfterSignin(View view) {
        login();
        TextView T=(TextView)findViewById(R.id.textView6);
        String txt=T.getText().toString();
        if (txt.length()<10) {
            Intent myIntent = new Intent(SignIn.this,
                    HomePage.class);
            startActivity(myIntent);// Do something in response to button
        }
    }

    public void loggedIn(String result)
    {
        Log.i("loggedIn:",result);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        if(result.equals(" logged in"))
        {
            Log.i("loggedIn:","YES");
            Intent myIntent = new Intent(SignIn.this,
                    HomePage.class).putExtra("EMAIL",UserName.getText().toString());
            startActivity(myIntent);
        }
    }
}
