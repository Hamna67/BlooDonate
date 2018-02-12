package com.example.marif.bloodapp.Page;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marif.bloodapp.FormValidators.FormValidation;
import com.example.marif.bloodapp.R;
import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.Connectivity.signupConnectivity;

public class SignUp extends AppCompatActivity {
    private EditText FirstName;
    private EditText LastName;
    private EditText Email;
    private EditText PhoneNumber;
    private EditText Password;
    private EditText Cpassword;

    //variable for checking if email already exists or not
    private boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        registerViews();
        check = false;
    }

    public void signUp(View view) {
        if ( checkValidation () )
        {
            Log.d("Submit:","test");
            String FirstNametext=FirstName.getText().toString();
            String LastNametext=LastName.getText().toString();
            String Emailtext=Email.getText().toString();
            String PhoneNumbertext=PhoneNumber.getText().toString();
            String Passwordtext=Password.getText().toString();
            String Cpasswordtext=Cpassword.getText().toString();
            Spinner City=(Spinner) findViewById(R.id.city_menu);
            String Citytext = City.getSelectedItem().toString();
            User user=new User(FirstNametext,LastNametext,Emailtext,PhoneNumbertext,Passwordtext,Citytext,null,null,0,0);
            if (Passwordtext.equals(Cpasswordtext))
            {
                new signupConnectivity(this,user, 0).execute();
            }
            else
            {
                Toast.makeText(SignUp.this, "Passwords Do not match", Toast.LENGTH_LONG).show();
            }

        }
        else
            Toast.makeText(SignUp.this, "Form contains error", Toast.LENGTH_LONG).show();

    }
    private void registerViews() {
        FirstName = (EditText) findViewById(R.id.First_Name);
        // TextWatcher would let us check validation error on the fly
        FirstName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.hasText(FirstName);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
        LastName = (EditText) findViewById(R.id.Last_Name);
        LastName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.hasText(LastName);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
        Email = (EditText) findViewById(R.id.email_input_signup);
        Email.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                FormValidation.isEmailAddress(Email, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        PhoneNumber = (EditText) findViewById(R.id.phone_input_signup);
        PhoneNumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.isPhoneNumber(PhoneNumber, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        Password = (EditText) findViewById(R.id.password_input_signup);
        Password.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.isPassword(Password, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
        Cpassword = (EditText) findViewById(R.id.confirm_password_input_signup);
        Cpassword.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.isPassword(Cpassword, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

    }

    public void submitForm(String text) {
        // Submit your form here. your form is valid

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        String expected = " Successful Signup ";
        if(text.equalsIgnoreCase(expected))
        {
            Intent myIntent = new Intent(SignUp.this, NumberVerify.class).putExtra("PHONE",PhoneNumber.getText().toString());
            startActivity(myIntent);
        }

    }



    private boolean checkValidation() {
        boolean ret = true;

        if (!FormValidation.hasText(FirstName)) ret = false;
        if (!FormValidation.hasText(LastName)) ret = false;
        if (!FormValidation.isEmailAddress(Email,true)) ret =false;
        if (!FormValidation.isPhoneNumber(PhoneNumber, true)) ret = false;
        if (!FormValidation.isPassword(Password, true)) ret = false;
        if (!FormValidation.isPassword(Cpassword, true)) ret = false;

        return ret;
    }
}
