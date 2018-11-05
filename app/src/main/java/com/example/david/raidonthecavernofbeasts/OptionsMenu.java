package com.example.david.raidonthecavernofbeasts;


import android.content.DialogInterface;
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
                char[] saveList = getIntent().getCharArrayExtra("GAME_SAVE_DATA");
                gameData.createSaveGame(saveList, getApplicationContext());
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
                String FileOutput = oldGameData.loadSavedGame(getApplicationContext());
                AlertDialog secondAlertDialog = new AlertDialog.Builder(OptionsMenu.this).create();
                secondAlertDialog.setMessage("Loaded!" + "\n" + "this is the " +
                        "output: " + FileOutput);
                secondAlertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                secondAlertDialog.show();

            }
        });
        final Button exitGame = (Button) findViewById(R.id.ExitGame);


        final Button back = (Button) findViewById(R.id.BackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });



    }


}
