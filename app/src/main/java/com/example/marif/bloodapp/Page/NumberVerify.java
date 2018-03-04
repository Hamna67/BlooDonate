package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marif.bloodapp.Connectivity.codeSendConnectivity;
import com.example.marif.bloodapp.Connectivity.numberVerifyConnectivity;
import com.example.marif.bloodapp.R;

public class NumberVerify extends AppCompatActivity {


    EditText Code;
    String phone;
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);
        phone= getIntent().getStringExtra("PHONE");
        Code=(EditText)findViewById(R.id.four_digit_code);

    }

    public void verify(View view)
    {
        code = Code.getText().toString();
        new numberVerifyConnectivity(this,phone,code).execute();
        Log.i("verify:","inside verfiy onclick");
    }


    public void verified(String result)
    {
        Log.i("verified:",result);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        if(result.equals(" verified"))
        {
            Log.i("Verified:","YES");
            goToUserBio();
        }
    }

    public void goToUserBio() {
        Intent myIntent = new Intent(NumberVerify.this,
                UserBio.class).putExtra("PHONE",phone);
        startActivity(myIntent);// Do something in response to button
    }

}
