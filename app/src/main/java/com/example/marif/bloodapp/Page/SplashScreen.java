package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marif.bloodapp.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMEOUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                Intent Splash=new Intent(SplashScreen.this, MainActivity.class);
                startActivity(Splash);
                finish();
            }

        },SPLASH_TIMEOUT);
        setContentView(R.layout.activity_splash_screen);

    }
}
