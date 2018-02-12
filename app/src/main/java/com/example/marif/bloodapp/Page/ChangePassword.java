package com.example.marif.bloodapp.Page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marif.bloodapp.Connectivity.signupConnectivity;
import com.example.marif.bloodapp.FormValidators.FormValidation;
import com.example.marif.bloodapp.R;

public class ChangePassword extends AppCompatActivity {
    private EditText oldpassword;
    private EditText newpassword;
    private EditText cnewpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        registerViewsCp();
    }

    public void ChangePass(View view) {
        if ( checkValidation () ) {

            String Oldpasswordtext = oldpassword.getText().toString();
            String Newpasswordtext = newpassword.getText().toString();
            String Cnewpasswordtext = cnewpassword.getText().toString();
            if (Newpasswordtext.equals(Cnewpasswordtext))
            {
            }
            else
            {
            }
        }}

    private void registerViewsCp() {
        newpassword = (EditText) findViewById(R.id.newpass);
        newpassword.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.isPassword(newpassword, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        cnewpassword = (EditText) findViewById(R.id.cnewpass);
        cnewpassword.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormValidation.isPassword(cnewpassword, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
    private boolean checkValidation() {
        boolean ret = true;
        if (!FormValidation.isPassword(newpassword, true)) ret = false;
        if (!FormValidation.isPassword(cnewpassword, true)) ret = false;
        return ret;
    }
}
