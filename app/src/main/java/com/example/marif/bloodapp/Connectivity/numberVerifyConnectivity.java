package com.example.marif.bloodapp.Connectivity;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.marif.bloodapp.Page.NumberVerify;
import com.example.marif.bloodapp.Page.SignIn;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by ABC on 2/13/2018.
 */

public class numberVerifyConnectivity extends AsyncTask<Void, Void, String> {

    private Context context;

    private String phone;
    private String code;

    private NumberVerify numberVerifyConext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public numberVerifyConnectivity(Context context, String ph,String c) {
        super();
        this.context = context;
        phone=ph;
        code = c;

        this.numberVerifyConext = (NumberVerify) context;
    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {


        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/VerifyCode.php?phone="+phone+"&code="+code;

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

        numberVerifyConext.verified(result);
    }

}
