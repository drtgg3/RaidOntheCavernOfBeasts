package com.example.david.raidonthecavernofbeasts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainMenu extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        final Button newGame = (Button) findViewById(R.id.NewGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, MapTraversal.class));
            }
        });


        final Button contineGame = (Button) findViewById(R.id.Continue);
        final Button aboutGame = (Button) findViewById(R.id.About);

    }

}
