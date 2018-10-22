package com.example.david.raidonthecavernofbeasts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MapTraversal extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_traversal);

        final arrayCreation Map = new arrayCreation();
        final eventManager eventHandler = new eventManager();
        final TextView eventViewer = (TextView) findViewById(R.id.EventViewer);


        final Button northButton = (Button) findViewById(R.id.North);
        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Map.currentRow == 0)
                {
                    String eventViewerText = "You cannot go north from here";
                    eventViewer.setText(eventViewerText);
                }
                else
                {
                    Map.moveNorth();
                    String eventViewerText = "You moved north\n You are now at (" + Map.currentRow + ","
                            + Map.currentColumn + ")" + "\n" + eventHandler.roomMove(Map.mapID);

                    eventViewer.setText(eventViewerText);
                }

            }
        });


        final Button eastButton = (Button) findViewById(R.id.East);
        eastButton.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v)
            {
                if(Map.currentColumn == 5)
                {
                    String eventViewerText = "You cannot go east from here";
                    eventViewer.setText(eventViewerText);
                }
                else
                {
                    Map.moveEast();
                    String eventViewerText = "You moved east\n You are now at (" + Map.currentRow + ","
                            + Map.currentColumn + ")" +"\n" + eventHandler.roomMove(Map.mapID);

                    eventViewer.setText(eventViewerText);
                }
            }
        });


        final Button southButton = (Button)findViewById(R.id.South);
        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Map.currentRow == 3)
                {
                    String eventViewerText = "You cannot go south from here";
                    eventViewer.setText(eventViewerText);
                }
                else
                {
                    Map.moveSouth();
                    String eventViewerText = "You moved south\n You are now at (" + Map.currentRow + ","
                            + Map.currentColumn + ")" + "\n" + eventHandler.roomMove(Map.mapID);

                    eventViewer.setText(eventViewerText);
                }
            }
        });

        final Button westButton = (Button) findViewById(R.id.West);
        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Map.currentColumn == 0)
                {
                    String eventViewerText = "You cannot go west from here";
                    eventViewer.setText(eventViewerText);
                }
                else
                {
                    Map.moveWest();
                    String eventViewerText = "You moved west\n You are now at (" + Map.currentRow + ","
                            + Map.currentColumn + ")" + "\n" + eventHandler.roomMove(Map.mapID);

                    eventViewer.setText(eventViewerText);
                }
            }
        });

        final Button takeButton =(Button) findViewById(R.id.Take);
        takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eventHandler.Item.roomCheck(Map.mapID))
                {
                    eventHandler.Item.pickupItem(Map.mapID);
                }
                else {
                    String eventViewerText = "NO items here!";
                    eventViewer.setText(eventViewerText);
                }
            }
        });

        final Button inventoryButton = (Button) findViewById(R.id.Inventory);
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventViewer.setText(eventHandler.Item.inventoryCheck());

            }
        });

        final Button optionsButton = (Button) findViewById(R.id.Options);
        optionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapTraversal.this, OptionsMenu.class));
            }
        });
    }


    public native String stringFromJNI();
}
