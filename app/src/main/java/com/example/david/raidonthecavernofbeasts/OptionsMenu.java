package com.example.david.raidonthecavernofbeasts;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class OptionsMenu extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    saveGame gameData = new saveGame();
    loadGame oldGameData = new loadGame();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);

        final Button save = (Button) findViewById(R.id.SaveGame);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stuff we need to save the game, just all the basic stuff for now so
                //the location (x,y) and the items the players has picked up
                char[] saveList = getIntent().getCharArrayExtra("GAME_SAVE_DATA");
                int xCoordinate = getIntent().getIntExtra("xCoordinate",0);
                int yCoordinate = getIntent().getIntExtra("yCoordinate",0);

                gameData.createSaveGame(saveList, xCoordinate, yCoordinate, getApplicationContext());

                AlertDialog alertDialog = new AlertDialog.Builder(OptionsMenu.this).create();
                alertDialog.setMessage("Saved the game!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        final Button loadGame = (Button) findViewById(R.id.LoadGame);
        loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] fileOutput = oldGameData.loadSavedGame(getApplicationContext());

                if(fileOutput.length == 0) {
                    AlertDialog thirdAlertDialog = new AlertDialog.Builder(OptionsMenu.this).create();
                    thirdAlertDialog.setMessage("Something went wrong! No file data!");

                    thirdAlertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                            new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                }

                else {
                    AlertDialog secondAlertDialog = new AlertDialog.Builder(OptionsMenu.this).create();
                    secondAlertDialog.setMessage("Loaded!");

                    secondAlertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    secondAlertDialog.show();


                    Intent loading = new Intent();
                    loading.putExtra("itemData", fileOutput[0]);
                    loading.putExtra("xCoordinate", Integer.parseInt(fileOutput[1]));
                    loading.putExtra("yCoordinate", Integer.parseInt(fileOutput[2]));
                    setResult(RESULT_OK, loading);
                    finish();
                }
            }

        });
        final Button exitGame = (Button) findViewById(R.id.ExitGame);


        final Button back = (Button) findViewById(R.id.BackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }

        });



    }


}
