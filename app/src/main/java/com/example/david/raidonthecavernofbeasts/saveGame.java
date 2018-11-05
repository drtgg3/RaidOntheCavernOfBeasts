package com.example.david.raidonthecavernofbeasts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


public class saveGame
{

    int stuff= 0;


    void createSaveGame(char[] saveList, Context ctx)
    {
        String finalSaveList  = new String (saveList);

        try{
            FileOutputStream outputStream = ctx.openFileOutput("GAMESAVE.txt",
                    Context.MODE_PRIVATE);
            outputStream.write(finalSaveList.getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            stuff = 20;
            e.printStackTrace();


        }


    }

}
