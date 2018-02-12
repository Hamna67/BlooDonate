package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marif.bloodapp.FormValidators.FormValidation;
import com.example.marif.bloodapp.R;
import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.Connectivity.userBioConnectivity;

public class UserBio extends AppCompatActivity {
    private EditText Weight;
    private EditText Height;
    private EditText Dob;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bio);
        registerViews();
        phone= getIntent().getStringExtra("PHONE");
    }

    public void goToHomeAfterSignup(View view) {
        if ( checkValidation () )
        {Log.d("Submit:","test");
        String Weighttext=Weight.getText().toString();
        int Weightnum=Integer.parseInt(Weighttext);
        String Heighttext=Height.getText().toString();
        int Heightnum=Integer.parseInt(Heighttext);
        String Dobtext=Dob.getText().toString();
        Spinner BloodType =(Spinner) findViewById(R.id.bloodtype_userbio);
        String Bloodtypetext =BloodType.getSelectedItem().toString();

        User user=new User(null,null,null,phone, null,null,Dobtext,Bloodtypetext,Weightnum,Heightnum);
        new userBioConnectivity(this,user, 0).execute();

    }
        else
                Toast.makeText(UserBio.this, "Form contains error", Toast.LENGTH_LONG).show();
    }

    private void registerViews() {
        Weight = (EditText) findViewById(R.id.weight_userbio);
        // TextWatcher would let us check validation error on the fly
        Weight.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.hasText(Weight);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

       Height = (EditText) findViewById(R.id.height_userbio);
        // TextWatcher would let us check validation error on the fly
        Height.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.hasText(Height);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        Dob = (EditText) findViewById(R.id.dob_userbio);
        // TextWatcher would let us check validation error on the fly
        Dob.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.hasText( Dob);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    public void submitForm(String text) {
        // Submit your form here. your form is valid

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        String expected = " Successful Entry ";
        if (text.equalsIgnoreCase(expected)) {

            Intent myIntent = new Intent(UserBio.this, HomePage.class).putExtra("PHONE", phone);

            startActivity(myIntent);// Do something in response to button
        }
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!FormValidation.hasText(Weight)) ret = false;
        if (!FormValidation.hasText(Height)) ret = false;
        if (!FormValidation.hasText(Dob)) ret = false;
        return ret;
    }
}
