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
import android.widget.TextView;

import com.example.marif.bloodapp.Page.SignIn;

public class signinConnectivity extends AsyncTask<Void, Void, String> {


    private TextView view;
    private Context context;
    private int byGetOrPost = 0;
    private String phone;
    private String password;

    private SignIn signInConext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public signinConnectivity(Context context, TextView text,String ph,String P, int flag) {
        super();
        this.context = context;
        byGetOrPost = flag;
        this.view = text;
        phone=ph;
        password=P;

        this.signInConext = (SignIn) context;
    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {


        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/SignIn.php?phone="+phone+"&password="+password;

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
        signInConext.loggedIn(result);
    }

}
