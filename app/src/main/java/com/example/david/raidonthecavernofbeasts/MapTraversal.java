package com.example.david.raidonthecavernofbeasts;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MapTraversal extends AppCompatActivity implements LifecycleObserver  {

    String gameData;
    int xCoordinate;
    int yCoordinate;
    boolean loadData = false;
    final arrayCreation Map = new arrayCreation();
    final eventManager eventHandler = new eventManager();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_traversal);


        //final arrayCreation Map = new arrayCreation();
        //final eventManager eventHandler = new eventManager();
        final TextView eventViewer = (TextView) findViewById(R.id.EventViewer);

        //have to initialize it right away to avoid potential saving issues.
        eventHandler.Item.initializeSaveList();

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
                Intent intent = new Intent (MapTraversal.this,OptionsMenu.class);
                intent.putExtra("GAME_SAVE_DATA", eventHandler.Item.saveList);
                intent.putExtra("xCoordinate", Map.currentRow);
                intent.putExtra("yCoordinate",Map.currentColumn);
                startActivityForResult(intent,1);
            }
        });


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void loadCheck (){
        if (loadData){
            Map.currentRow = xCoordinate;
            xCoordinate = 0;
            Map.currentColumn = yCoordinate;
            yCoordinate = 0;
            eventHandler.Item.loadSaveList(gameData);
            gameData = "";
            loadData = false;

            TextView eventViewer = (TextView) findViewById(R.id.EventViewer);

            String eventViewerText = "You are now at (" + Map.currentRow + ","
                    + Map.currentColumn + ")" + "\n" + eventHandler.roomMove(Map.mapID);
            eventViewer.setText(eventViewerText);
        }
        //}
    }

    //really wont ever go off unless we go to the options menu to check if we have new data to input
    //through the load method there
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                gameData = data.getStringExtra("itemData");
                xCoordinate = data.getIntExtra("xCoordinate",0);
                yCoordinate = data.getIntExtra("yCoordinate",0);
                loadData = true;
            }
        }

    }


    public native String stringFromJNI();
}
