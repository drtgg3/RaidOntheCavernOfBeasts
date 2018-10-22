package com.example.david.raidonthecavernofbeasts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OptionsMenu extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);

        final Button saveGame = (Button) findViewById(R.id.SaveGame);
        final Button loadGame = (Button) findViewById(R.id.LoadGame);
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
