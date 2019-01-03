package com.apps.team40.a6thtry;

import java.util.ArrayList;

public class GlobalList {
    public static ArrayList<TeamStats> teams = new ArrayList<>();

    public static void add (TeamStats team){
        if (team != null){
            GlobalList.teams.add(team);
        }
    }
}
