package com.example.david.raidonthecavernofbeasts;

import android.content.Context;
import java.io.FileOutputStream;



public class saveGame
{

    int errorCheck= 0;


    void createSaveGame(char[] saveList, int xCoordinate, int yCoordinate, Context ctx)
    {
        String finalSaveList  = new String (saveList);
        String x =  " " + Integer.toString(xCoordinate);
        String y =  " " + Integer.toString(yCoordinate);
        try{
            FileOutputStream outputStream = ctx.openFileOutput("GAMESAVE.txt",
                    Context.MODE_PRIVATE);
            outputStream.write(finalSaveList.getBytes());
            outputStream.write(x.getBytes());
            outputStream.write(y.getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            errorCheck = 20;
            e.printStackTrace();


        }


    }

}
