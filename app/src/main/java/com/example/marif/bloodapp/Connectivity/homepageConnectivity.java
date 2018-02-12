package com.example.marif.bloodapp.Connectivity;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.marif.bloodapp.Page.HomePage;
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
 * Created by ABC on 12/14/2017.
 */

public class homepageConnectivity extends AsyncTask<Void, Void, String> {
    User new_user;
    String phone;
    private Context context;
    private int byGetOrPost = 0;

    HomePage homePageContext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public homepageConnectivity(Context context,String phone, int flag) {
        super();
        this.context = context;
        byGetOrPost = flag;
        this.phone=phone;

        this.homePageContext = (HomePage) context;

    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {



        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/RetrieveRegistration.php?phone="+phone+"";;

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
        String[] values=result.split("\\*.\\*");
        //Log.d("home retrieveing",values);
        Log.d("home retrieveing",values[0] + values[1]+values[2]+values[3]);
        new_user = new User(values[0],values[1],values[5],values[2],null,values[3],values[5],values[8],Integer.parseInt(values[6]),Integer.parseInt(values[7]));
        homePageContext.populate(new_user);
        Log.d("home retrieveing",result);

    }


}
