package com.example.marif.bloodapp.Connectivity;

/**
 * Created by M. Arif on 11/16/2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.marif.bloodapp.Page.MainActivity;
import com.example.marif.bloodapp.Page.NumberVerify;
import com.example.marif.bloodapp.Page.SignIn;
import com.example.marif.bloodapp.Page.SignUp;

public class codeSendConnectivity extends AsyncTask<Void, Void, String> {


    private TextView view;
    private Context context;
    private int byGetOrPost = 0;
    private String phone;
    private String password="peanut";

    private SignUp signUpConext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public codeSendConnectivity(Context context, String ph) {
        super();
        this.context = context;

        phone=ph;

        this.signUpConext = (SignUp) context;
        Log.i("inside const code:","const");
    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {

        Log.i("inside back code:","background");
        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/sendVerificationText.php?phone="+phone;

            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }

            in.close();
            return sb.toString();
        } catch (Exception e) {
            return new String("Exception: GET" + e.getMessage());
        }



    }

    @Override
    protected void onPostExecute(String result){
        //this.view.setText(result);
        signUpConext.codeSent(result);
    }

}
