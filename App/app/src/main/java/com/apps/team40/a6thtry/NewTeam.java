package com.apps.team40.a6thtry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;

public class NewTeam extends AppCompatActivity {
//public class NewTeam extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Spinner spinner = (Spinner) findViewById(R.id.TeamStatsInput);
    TeamStats team = new TeamStats();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_team);


    }


    /*public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {


        1. General
        2. Auto
        3. TeleOp
        4. EndGame

        if (iCurrentSelection != pos){
            EditText TeamName = findViewById(R.id.teamName);
            EditText TeamNum = findViewById(R.id.teamNum);
            EditText BotName = findViewById(R.id.botName);
            EditText School = findViewById(R.id.school);

            if (pos == 0){
                TeamName.setVisibility(View.VISIBLE);

            }else if (pos == 1){
                TeamName.setVisibility(View.GONE);
            }else if (pos == 2){
                TeamName.setVisibility(View.GONE);
            }
        }
        iCurrentSelection = pos;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        return;
    }
*/
    private Integer ToInt(String s){
        try {
            return Integer.parseInt(s);
        }
        catch( Exception e ) {
            return 0;
        }
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
    public void PartiallyParked (View view) {team.Parked_Partially = bool(team.Parked_Partially);}
    public void ParkedCompletly (View view) {team.Parked_Completely = bool(team.Parked_Completely);}



    public void saveTeam(View view){
        EditText TeamName = findViewById(R.id.teamName);
        EditText TeamNum = findViewById(R.id.teamNum);
        EditText BotName = findViewById(R.id.botName);
        EditText School = findViewById(R.id.school);
        EditText DepotGold = findViewById(R.id.depotGold);
        EditText DepotSilver = findViewById(R.id.depotSilver);
        EditText CargoBayGold = findViewById(R.id.cargoBayGold);
        EditText CargoBaySilver = findViewById(R.id.cargoBaySilver);
        EditText EndDepotGold = findViewById(R.id.endDepotGold);
        EditText EndDepotSilver = findViewById(R.id.endDepotSilver);
        EditText EndCargoGold = findViewById(R.id.endCargoGold);
        EditText EndCargoSilver = findViewById(R.id.endCargoSilver);
        EditText Notes = findViewById(R.id.notes);
        EditText MatchNotes = findViewById(R.id.tourny);




        //general Stats
        team.TeamName = TeamName.getText().toString();
        System.out.println("Team name: " + team.TeamName);
        team.TeamNum = (ToInt(TeamNum.getText().toString()));
        team.BotName = BotName.getText().toString();
        team.School = School.getText().toString();
        team.Depot_Gold = ToInt(DepotGold.getText().toString());
        team.Depot_Silver = ToInt(DepotSilver.getText().toString());
        team.Cargo_Bay_Gold = ToInt(CargoBayGold.getText().toString());
        team.Cargo_Bay_Silver = ToInt(CargoBaySilver.getText().toString());
        team.End_Depot_Gold = ToInt(EndDepotGold.getText().toString());
        team.End_Depot_Silver = ToInt(EndDepotSilver.getText().toString());
        team.End_Cargo_Bay_Gold = ToInt(EndCargoGold.getText().toString());
        team.End_Cargo_Bay_Silver = ToInt(EndCargoSilver.getText().toString());
        team.teamNotes = Notes.getText().toString();
        team.tournamentNotes = MatchNotes.getText().toString();



        GlobalList.add(team);

        Saving s = new Saving();
        try {
            s.Save(team, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}