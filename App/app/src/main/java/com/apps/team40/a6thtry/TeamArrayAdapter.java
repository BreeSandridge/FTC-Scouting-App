package com.apps.team40.a6thtry;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import java.util.ArrayList;

//import com.codexpedia.list.viewholder.R;


public class TeamArrayAdapter extends RecyclerView.Adapter<TeamArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listTeamLayout;
    private static ArrayList<TeamStats> teamList;
    public static TeamStats teamPick;
    // Constructor of the class
    public TeamArrayAdapter(int layoutId, ArrayList<TeamStats> teamList) {
        listTeamLayout = layoutId;
        this.teamList = teamList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return teamList == null ? 0 : teamList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listTeamLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView team = holder.team;
        team.setText(teamList.get(listPosition).TeamName);
        teamPick = teamList.get(listPosition);
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView team;
        private int listPos;

        public ViewHolder(View teamView) {
            super(teamView);
            teamView.setOnClickListener(this);
            team = (TextView) teamView.findViewById(R.id.row_item);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + team.getText());
        }

        public TeamStats getTeam(){
            return teamList.get(listPos);
        }
        public TextView getTextView(){
            return team;
        }
    }
}
