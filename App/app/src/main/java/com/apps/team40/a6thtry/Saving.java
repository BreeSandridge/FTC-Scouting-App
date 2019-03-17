package com.apps.team40.a6thtry;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Saving {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void Save(TeamStats t, Context context) throws IOException {

        String FilePath = "/Files/"+t.TeamNum+'#'+t.TeamNum+".txt";
        File file = new File(context.getFilesDir(), FilePath);
        boolean exists = file.exists();


        //if(exists){
            String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";

            String fileContents = "Hello world!";
            FileOutputStream outputStream;

            try {
                outputStream = context.openFileOutput(FilePath, context.MODE_PRIVATE);
                outputStream.write(fileContents.getBytes());
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        //}
        //String filename = t.TeamName+'#'+t.TeamNum;
        //String fileContents = gson.toJson(t);
        //FileOutputStream outputStream;


    }
}
