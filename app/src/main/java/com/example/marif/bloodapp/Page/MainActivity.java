package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marif.bloodapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signIn(View view) {
        Intent myIntent = new Intent(MainActivity.this,
                SignIn.class);
        startActivity(myIntent);// Do something in response to button
    }
    public void signUp(View view) {
        Intent myIntent = new Intent(MainActivity.this,
                SignUp.class);
        startActivity(myIntent);// Do something in response to button
    }
    public void aboutUs(View view) {
        Intent myIntent = new Intent(MainActivity.this,
                AboutUs.class);
        startActivity(myIntent);// Do something in response to button
    }
}
