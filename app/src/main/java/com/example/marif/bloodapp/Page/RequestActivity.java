package com.example.marif.bloodapp.Page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.marif.bloodapp.PageAdapter.CustomRequestAdapter;
import com.example.marif.bloodapp.R;
import com.example.marif.bloodapp.Connectivity.RequestConnectivity;
import com.example.marif.bloodapp.Entity.User;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity {

   // ListView requestList;
 //   GridView requestList;
   RecyclerView requestList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        String phone;
        phone= getIntent().getStringExtra("PHONE");
        new RequestConnectivity(this,phone, 0).execute();

    }

    public void populate(ArrayList<User> userList)
    {


      //  requestList = (ListView) findViewById(R.id.requestListView);
    //    requestList = (GridView) findViewById(R.id.requestListView);
        requestList = (RecyclerView) findViewById(R.id.requestRecyclerView);
        requestList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        requestList.setLayoutManager(llm);
        CustomRequestAdapter customAdapter = new CustomRequestAdapter(getApplicationContext(), userList);
        requestList.setAdapter(customAdapter);

    }
}
