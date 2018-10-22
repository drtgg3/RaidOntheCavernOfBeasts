package com.example.david.raidonthecavernofbeasts;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.FileInputStream;


public class saveGame
{
    Context contextMaker;

    void createSaveGame()
    {
        String filename = "GAMESAVE";
        String fileContent = "Just a test";
        FileOutputStream output;
        try{
            output = contextMaker.openFileOutput(filename,Context.MODE_PRIVATE);
            output.write(fileContent.getBytes());
            output.close();
        } catch (Exception e)
        {
            //log error
        }
    }


}
