package com.apps.team40.a6thtry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Toast;

import com.apps.team40.a6thtry.OldRecyclerView.Contact;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lookup the recyclerview in activity layout
        RecyclerView rvTeams = (RecyclerView) findViewById(R.id.rvTeams);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        TeamAdapter adapter = new TeamAdapter(GlobalList.teams);
        // Attach the adapter to the recyclerview to populate items
        rvTeams.setAdapter(adapter);
        // Set layout manager to position the items
        rvTeams.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvTeams.addItemDecoration(itemDecoration);

        rvTeams.setItemAnimator(new SlideInUpAnimator());


        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvTeams);



        ItemClickSupport.addTo(rvTeams).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        // do it
                        Open(v, position);
                    }
                }
        );




    }


    public void Open(View view, int position){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("KEY", GlobalList.teams.get(position));
        startActivity(intent);
    }
    public void NewTeam(View view) {
        Intent intent = new Intent(this, NewTeam.class);
        //teamList.add(new TeamStats());
        //intent.putExtra("Key", teamList.get(teamList.size()-1));
        startActivity(intent);
    }


}
