package com.apps.team40.a6thtry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

//public class DisplayMessageActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public class DisplayMessageActivity extends AppCompatActivity {
    public TeamStats team = new TeamStats();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = getSupportActionBar();

        //Menu m = menu(R.menu.menu_view_team);
        //onCreateOptionsMenu(m);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        team = (TeamStats) intent.getSerializableExtra("KEY");

        setTitle(team.TeamName);

        ScrollView s = findViewById(R.id.ScrollViewer);
        s.setSmoothScrollingEnabled(true);


        TextView teamNum = findViewById(R.id.teamNum);
        teamNum.setText(String.valueOf(team.TeamNum));

        TextView RobotName = findViewById(R.id.botName);
        RobotName.setText(team.BotName);

        TextView School = findViewById(R.id.school);
        School.setText(team.School);

        TextView Landing = findViewById(R.id.landing);
        Landing.setText(boolString(team.Landing));

        TextView Claiming = findViewById(R.id.claiming);
        Claiming.setText(boolString(team.Claiming));

        TextView Parking = findViewById(R.id.Parking);
        Parking.setText(boolString(team.Parking));

        TextView Sampling = findViewById(R.id.sampling);
        Sampling.setText(boolString(team.Sampling));

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

        TextView Latching = findViewById(R.id.latching);
        Latching.setText(boolString(team.Latched));

        TextView PartiallyParked = findViewById(R.id.partiallyParked);
        PartiallyParked.setText(boolString(team.Parked_Partially));

        TextView ParkedCompletly = findViewById(R.id.fullyParked);
        ParkedCompletly.setText(boolString(team.Parked_Completely));

        TextView Notes = findViewById(R.id.notes);
        Notes.setText(team.teamNotes);

        TextView MatchNotes = findViewById(R.id.matchNotes);
        MatchNotes.setText(team.tournamentNotes);









        /*Spinner gameState = (Spinner) findViewById(R.id.gameStageDropDownMenu);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gameStateArray, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        gameState.setAdapter(adapter);
        gameState.setOnItemSelectedListener(this);*/



    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_view_team, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Settings();
                return true;
           /* case R.id.help:
                showHelp();
                return true;(*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Settings(){

    }
    public String boolString (boolean bool){
        if (bool){
            return "True";
        }else{
            return "False";
        }
    }


    public void Done (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void edit (View view){
        Intent i = new Intent(this, Edit.class);
        i.putExtra("KEY", team);
        startActivity(i);
    }
    /*public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String selected = parent.getItemAtPosition(pos).toString();
        System.out.println("\"" + selected + "\"");

        TextView gameStateTitle = findViewById(R.id.GameStateTitle);
        TextView totalPoints = findViewById(R.id.totalPoints);


        CheckBox landing = (CheckBox) findViewById(R.id.Landing);
        if (landing.isChecked()) {
            landing.setChecked(false);
        }












        if (selected.equals("TeleOp")){
            System.out.println("TELEOPWASCHOSEN");
            totalPoints.setText(team.getTele_Total_Points());
            gameStateTitle.setText("Tele Op");
        }else if (selected.equals("End Game")){
            totalPoints.setText(team.getEnd_Total_Points());
            gameStateTitle.setText("End Game");
        }else if (selected.equals("Auto")){
            //totalPoints.setText(team.getAuto_Total());
            gameStateTitle.setText("Autonomous");
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
}
