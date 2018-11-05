package com.example.david.raidonthecavernofbeasts;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class loadGame {

    String loadSavedGame(Context ctx){
        String GAMEDATA = "";
        try {
            FileInputStream fis = ctx.openFileInput("GAMESAVE.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while ((GAMEDATA = bufferedReader.readLine()) != null)
            {
                sb.append(GAMEDATA);
            }
            return sb.toString();
        }
        catch (Exception e) {
            GAMEDATA = "COULDNT FIND THE FILE";

        }
        return GAMEDATA;
    }


}
