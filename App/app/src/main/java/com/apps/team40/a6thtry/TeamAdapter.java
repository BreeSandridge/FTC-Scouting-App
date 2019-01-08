package com.apps.team40.a6thtry;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class TeamAdapter extends
        RecyclerView.Adapter<TeamAdapter.ViewHolder> {



    // Define listener member variable
    private OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView numberTextView;
        public TextView schoolTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.team_name);
            numberTextView = (TextView) itemView.findViewById(R.id.team_number);
            schoolTextView = (TextView) itemView.findViewById(R.id.school);

            //Setup onclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });


        }
    }

    // Store a member variable for the contacts
    private List<TeamStats> mTeams;

    // Pass in the contact array into the constructor
    public TeamAdapter(List<TeamStats> teamStats) {
        mTeams = teamStats;
    }

    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View TeamView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(TeamView);
        return viewHolder;
    }



    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(TeamAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        TeamStats team = mTeams.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText("Team: " + team.TeamName);
        textView = viewHolder.numberTextView;
        textView.setText(String.valueOf("#" + team.TeamNum));
        textView = viewHolder.schoolTextView;
        textView.setText("School: " + team.School);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mTeams.size();
    }
}
