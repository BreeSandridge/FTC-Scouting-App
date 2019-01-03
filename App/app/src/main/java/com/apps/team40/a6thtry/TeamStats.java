package com.apps.team40.a6thtry;

import java.io.Serializable;

public class TeamStats implements Serializable, Cloneable {
//public class TeamStats {
    //General Info
    public String TeamName;
    public int TeamNum;
    public String BotName;
    public String School;

    //Autonomous
    public boolean Landing = false;
    public boolean Claiming = false;
    public boolean Parking = false;
    public boolean Sampling = false;
    public int auto_Total = 0;



    //TeleOp
    public int Depot_Total = 0;
    public int Depot_Gold = 0;
    public int Depot_Silver = 0;
    public int Cargo_Bay_TOTAL = 0;
    public int Cargo_Bay_Gold = 0;
    public int Cargo_Bay_Silver = 0;
    public int Tele_Total_Points = 0;



    //End Game
    public int End_Depot_Gold = 0;
    public int End_Depot_Silver = 0;
    public int End_Cargo_Bay_Gold = 0;
    public int End_Cargo_Bay_Silver = 0;
    public boolean Latched = false;
    public boolean Parked_Partially = false;
    public boolean Parked_Completely = false;
    public int End_Total_Points = 0;

    public TeamStats(){}




    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    //Auto total points
    public int getAuto_Total() {
        if (Landing){
            auto_Total += 30;
        }if (Claiming){
            auto_Total += 15;
        }if (Parking){
            auto_Total += 10;
        }if (Sampling){
            auto_Total += 25;
        }
        return auto_Total;
    }



    //Tele
    public int getDepot_Total() {
        Depot_Total = Depot_Silver+Depot_Gold;
        return Depot_Total;
    }
    public int getCargo_Bay_TOTAL() {
        Cargo_Bay_TOTAL = Cargo_Bay_Gold + Cargo_Bay_Silver;
        return Cargo_Bay_TOTAL;
    }
    public int getTele_Total_Points() {
        Tele_Total_Points = getDepot_Total() * 2 + getCargo_Bay_TOTAL() * 2;

        return Tele_Total_Points;
    }


    //end
    public int getEnd_Total_Points() {
        End_Total_Points += (End_Depot_Gold + End_Depot_Silver) * 2 + (End_Cargo_Bay_Gold + End_Cargo_Bay_Silver) * 5;

        if (Latched){
            End_Total_Points += 30;
        }else if (Parked_Completely){
            End_Total_Points += 25;
        }else if (Parked_Partially){
            End_Total_Points += 15;
        }

        return End_Total_Points;
    }
}
