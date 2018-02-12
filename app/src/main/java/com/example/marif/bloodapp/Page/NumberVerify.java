package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marif.bloodapp.R;

public class NumberVerify extends AppCompatActivity {

    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);
        phone= getIntent().getStringExtra("PHONE");
    }
    public void goToUserBio(View view) {
        Intent myIntent = new Intent(NumberVerify.this,
                UserBio.class).putExtra("PHONE",phone);
        startActivity(myIntent);// Do something in response to button
    }
}
