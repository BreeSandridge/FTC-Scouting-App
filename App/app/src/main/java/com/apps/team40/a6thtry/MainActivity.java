package com.apps.team40.a6thtry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

//import com.codexpedia.list.viewholder.R;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.apps.team40.clickcounter";
    RecyclerView recyclerView;
    public TeamArrayAdapter teamArrayAdapter = new TeamArrayAdapter(R.layout.list_item, GlobalList.teams);


    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();


        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(teamArrayAdapter);











        for (int i = 0; i < GlobalList.teams.size(); i++){
            System.out.println(GlobalList.teams.get(i).TeamName);
            System.out.println(GlobalList.teams.size());
        }

    }

    public void OpenTeam(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        //System.out.println(team.getTeamName());
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println("##########################");


        //intent.putExtra(EXTRA_MESSAGE, teamArrayAdapter.teamPick.getTeamName());

        intent.putExtra("KEY", teamArrayAdapter.teamPick);
        startActivity(intent);
    }

    public void NewTeam(View view) {
        Intent intent = new Intent(this, NewTeam.class);
        //teamList.add(new TeamStats());
        //intent.putExtra("Key", teamList.get(teamList.size()-1));
        startActivity(intent);
    }

}