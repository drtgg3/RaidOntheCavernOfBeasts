package com.example.david.raidonthecavernofbeasts;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class loadGame {

    String[] loadSavedGame(Context ctx){
        String[] gameData = new String[3];
        try {
            FileInputStream fis = ctx.openFileInput("GAMESAVE.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String reading = null;
            int counter=0;

            while ((reading = bufferedReader.readLine()) != null)
            {
                String[] splitted = reading.split("\\s+");
                for(String part : splitted){
                    gameData[counter]  = part;
                    counter+=1;
                }
            }

            fis.close();
            return gameData;
        }
        catch (Exception e) {
            gameData[0] = "Something went wrong with the file!";

        }

        return gameData;
    }


}
