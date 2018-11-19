package com.example.david.raidonthecavernofbeasts;

import java.lang.reflect.Array;
import java.util.Arrays;


public class inventoryManager {
    boolean torch = false;
    boolean potion = false;
    boolean swordOfKings = false;
    char[] saveList = new char[3];


    void initializeSaveList() {
        Arrays.fill(saveList, '0');
    }



    String inventoryCheck() {
        //this is pretty primitive and might change later on depending
        //on if I want to add a menu option that shows the players
        //what they do and dont have
        String Inventory = "What you have in your inventory: ";

        if (torch) {
            Inventory += "\n-An Unlit torch";
        }

        if (potion) {
            Inventory += "\n-A strange bottled concoction of some sort";
        }

        if (swordOfKings) {
            Inventory += "\n-A mystical sword that makes a soft"
                    + " but high pitched noise as you swing it around";
        }

        return Inventory;

    }

    boolean roomCheck(int roomId) {
        //checks if the room has an item in it or not
        if (roomId == 0 || roomId == 1 || roomId == 2) {
            return true;
        }
        return false;

    }

    void pickupItem(int roomId) {
        switch (roomId) {
            case 0: {
                torch = true;
                break;
            }
            case 1: {
                potion = true;
                break;
            }
            case 2: {
                swordOfKings = true;
                break;
            }
        }
        //every time we pick up an item it is going to be necessary
        //to keep track of it here, even if we choose not to save.
        createSaveList();

    }

    void createSaveList(){
        if(torch) {
            saveList[0] ='1';
        }
        else
        {
            saveList[0] = '0';
        }

        if(potion){
            saveList[1] = '1';
        }
        else
        {
            saveList[1] = '0';
        }

        if(swordOfKings){
            saveList[2] = '1';
        }
        else {
            saveList[2] = '0';
        }
    }

    void loadSaveList(String SaveList) {

        char [] charSaveList = SaveList.toCharArray();
        if (charSaveList[0] == '1')
        {
            torch = true;
        }
        else {
            torch = false;
        }

        if (charSaveList[1] == '1')
        {
            potion = true;
        }
        else {
            potion = false;
        }

        if(charSaveList[2] == '1')
        {
            swordOfKings = true;
        }
        else {
            swordOfKings = false;
        }
    }
}


