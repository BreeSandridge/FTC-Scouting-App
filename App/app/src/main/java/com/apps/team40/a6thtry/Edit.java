package com.apps.team40.a6thtry;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Edit extends AppCompatActivity {
    public TeamStats team = new TeamStats();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        team = (TeamStats) intent.getSerializableExtra("KEY");


        // Capture the layout's TextView and set the string as its text
        TextView teamName = findViewById(R.id.teamName);
        teamName.setText(team.TeamName);
        // Capture the layout's TextView and set the string as its text
        TextView teamNum = findViewById(R.id.teamNum);
        teamNum.setText(String.valueOf(team.TeamNum));

        TextView RobotName = findViewById(R.id.botName);
        RobotName.setText(team.BotName);

        TextView School = findViewById(R.id.school);
        School.setText(team.School);

        CheckBox Landing = findViewById(R.id.landing);
        Landing.setChecked(team.Landing);

        CheckBox Claiming = findViewById(R.id.claiming);
        Claiming.setChecked(team.Claiming);

        CheckBox Parking = findViewById(R.id.Parking);
        Parking.setChecked(team.Parking);

        CheckBox Sampling = findViewById(R.id.sampling);
        Sampling.setChecked(team.Sampling);

        TextView DepotGold = findViewById(R.id.depotGold);
        DepotGold.setText(String.valueOf(team.Depot_Gold));

        TextView DepotSilver = findViewById(R.id.depotSilver);
        DepotSilver.setText(String.valueOf(team.Depot_Silver));

        TextView CargoBayGold = findViewById(R.id.cargoBayGold);
        CargoBayGold.setText(String.valueOf(team.Cargo_Bay_Gold));

        TextView CargoBaySilver = findViewById(R.id.cargoBaySilver);
        CargoBaySilver.setText(String.valueOf(team.Cargo_Bay_Silver));

        TextView EndDepotGold = findViewById(R.id.endDepotGold);
        EndDepotGold.setText(String.valueOf(team.End_Depot_Gold));

        TextView EndDepotSilver = findViewById(R.id.endDepotSilver);
        EndDepotSilver.setText(String.valueOf(team.End_Depot_Silver));

        TextView EndCargoGold = findViewById(R.id.endCargoGold);
        EndCargoGold.setText(String.valueOf(team.End_Cargo_Bay_Gold));

        TextView EndCargoSilver = findViewById(R.id.endCargoSilver);
        EndCargoSilver.setText(String.valueOf(team.End_Cargo_Bay_Silver));

        CheckBox Latching = findViewById(R.id.latching);
        Latching.setChecked(team.Latched);

        CheckBox PartiallyParked = findViewById(R.id.partiallyParked);
        PartiallyParked.setChecked(team.Parked_Partially);

        CheckBox ParkedCompletly = findViewById(R.id.fullyParked);
        ParkedCompletly.setChecked(team.Parked_Completely);

        TextView Notes = findViewById(R.id.notes);
        Notes.setText(team.teamNotes);

        TextView MatchNotes = findViewById(R.id.matchNotes);
        MatchNotes.setText(team.tournamentNotes);


    }



    public boolean bool(Boolean b){
        if (b){
            return false;
        }else{
            return true;
        }
    }
    public void LandingActivate(View view){
        team.Landing = bool(team.Landing);
        System.out.println(team.Landing);
    }
    public void ClaimingActivate(View view){
        team.Claiming = bool(team.Claiming);
    }
    public void ParkingActivate(View view){
        team.Parking = bool(team.Parking);
    }
    public void SamplingActivate (View view){
        team.Sampling = bool(team.Sampling);
    }
    public void LatchingActivate (View view){
        team.Latched = bool(team.Latched);
    }
    public void PartiallyParked (View view) {
        team.Parked_Partially = bool(team.Parked_Partially); }
    public void ParkedCompletly (View view) {
        team.Parked_Completely = bool(team.Parked_Completely);}



    public void Done (View view){
        Intent i = new Intent(this, DisplayMessageActivity.class);
        i.putExtra("KEY", team);
        startActivity(i);
    }
}
