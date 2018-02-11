package com.example.marif.bloodapp.PageAdapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.R;

import java.util.ArrayList;

/**
 * Created by ABC on 12/19/2017.
 */

public class CustomRequestAdapter extends RecyclerView.Adapter<CustomRequestAdapter.PersonViewHolder> {

    Context context;
    ArrayList<User> userList;
    LayoutInflater inflter;

    public CustomRequestAdapter(Context applicationContext, ArrayList<User> ul) {
        this.context = context;
        this.userList = ul;
        inflter = (LayoutInflater.from(applicationContext));
    }


    public int getItemCount() {
        return userList.size();
    }

   /*
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview_request, null);
       // view = inflter.inflate(R.layout.activity_card_request, null);
        TextView fname = (TextView) view.findViewById(R.id.FirstName);
        TextView lname = (TextView) view.findViewById(R.id.LastName);
        TextView email = (TextView) view.findViewById(R.id.Email);
        TextView phone = (TextView) view.findViewById(R.id.Phone);
        TextView city = (TextView) view.findViewById(R.id.City);

        fname.setText(((User)userList.get(i)).getFirstName());
        lname.setText(((User)userList.get(i)).getLastName());
        email.setText(((User)userList.get(i)).getEmail());
        phone.setText(((User)userList.get(i)).getPhoneNum());
        city.setText(((User)userList.get(i)).getCity());

        return view;
    }
    */


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_request, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {


        personViewHolder.fname.setText(((User)userList.get(i)).getFirstName());
        personViewHolder.lname.setText(((User)userList.get(i)).getLastName());
        personViewHolder.email.setText(((User)userList.get(i)).getEmail());
        personViewHolder.phone.setText(((User)userList.get(i)).getPhoneNum());
        personViewHolder.city.setText(((User)userList.get(i)).getCity());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView fname;
        TextView lname;
        ImageView personPhoto;
        TextView email;
        TextView phone;
        TextView city;




        PersonViewHolder(View itemView) {

            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardview);
            fname = (TextView)itemView.findViewById(R.id.FirstName);
            lname = (TextView)itemView.findViewById(R.id.LastName);
            email = (TextView)itemView.findViewById(R.id.Email);
            phone = (TextView)itemView.findViewById(R.id.Phone);
            city = (TextView)itemView.findViewById(R.id.City);
            //    personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

}