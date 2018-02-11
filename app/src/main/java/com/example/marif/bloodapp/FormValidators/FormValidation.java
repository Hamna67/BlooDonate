package com.example.marif.bloodapp.FormValidators;

/**
 * Created by M. Arif on 12/13/2017.
 */
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by M. Arif on 12/13/2017.
 */

public class FormValidation {
    // Regular Expression
    // you can change the expression based on your need
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "\\d{4}-\\d{7}";
    private static final String PASSWORD_REGEX="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=?-]).{8,15}$";
    private static final String DOB_REGEX="";
    // Error Messages
    private static final String REQUIRED_MSG = "Required";
    private static final String PASSWORD_MSG = "Atleast 1 Capital letter, 1 Small letter, 1 Digit, 1 Symbol and between 8 and 15";
    private static final String EMAIL_MSG = "Invalid email";
    private static final String PHONE_MSG = "eg: 0333-5151324";
    private static final String DOB_MSG = "eg: 0333-5151324";
    // call this method when you need to check email validation
    public static boolean isEmailAddress(EditText editText, boolean required) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required);
    }

    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required);
    }

    public static boolean isPassword(EditText editText,boolean required)
    {
        return isValid(editText, PASSWORD_REGEX, PASSWORD_MSG, required);
    }

    public static boolean isDob(EditText editText,boolean required)
    {
        return isValid(editText, DOB_REGEX, DOB_MSG, required);
    }
     // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);
        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }

}
