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

import com.example.marif.bloodapp.Page.SignUp;
import com.example.marif.bloodapp.Entity.User;

public class signupConnectivity extends AsyncTask<Void, Void, String> {

    User new_user;
    private Context context;
    private int byGetOrPost = 0;

    SignUp signUpContext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public signupConnectivity(Context context,User U, int flag) {
        super();
        this.context = context;
        byGetOrPost = flag;
        new_user=U;

        this.signUpContext = (SignUp)context;

    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {


        String FN=new_user.getFirstName();
        String LN=new_user.getLastName();
        String Em=new_user.getEmail();
        String Ph=new_user.getPhoneNum();
        String Pass=new_user.getPassword();
        String City=new_user.getCity();


        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/SignUp.php?fname="+FN+"&lname="+LN+"&password="+Pass+"&phone="+Ph+"&city="+City+"&email="+Em+"";;

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
        signUpContext.submitForm(result);
    }


}
