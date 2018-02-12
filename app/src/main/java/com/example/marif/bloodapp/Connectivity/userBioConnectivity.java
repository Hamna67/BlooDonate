package com.example.marif.bloodapp.Connectivity;

import android.content.Context;
import android.os.AsyncTask;

import com.example.marif.bloodapp.Page.UserBio;
import com.example.marif.bloodapp.Entity.User;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by ABC on 12/18/2017.
 */

public class userBioConnectivity extends AsyncTask<Void, Void, String> {

    User new_user;
    private Context context;
    private int byGetOrPost = 0;

    UserBio userBioContext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public userBioConnectivity(Context context,User U, int flag) {
        super();
        this.context = context;
        byGetOrPost = flag;
        new_user=U;

        this.userBioContext = (UserBio)context;

    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {


        String Dob=new_user.getDateOfBirth();
        double h=new_user.getHeight();
        double w=new_user.getWeight();
        String bg=new_user.getBloodGroup();
        String Em=new_user.getEmail();
        String ph = new_user.getPhoneNum();


        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/StoreBioData.php?dateOfBirth="+Dob+"&height="+h+"&weight="+w+"&bloodGroup="+bg+"&phone="+ph+"";;

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
        userBioContext.submitForm(result);
    }


}