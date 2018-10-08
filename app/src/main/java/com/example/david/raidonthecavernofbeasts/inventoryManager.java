package com.example.david.raidonthecavernofbeasts;

public class inventoryManager {
    boolean torch = false;
    boolean potion = false;
    boolean swordOfKings = false;

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

    boolean roomCheck(int roomId)
    {
        //checks if the room has an item in it or not
        if(roomId == 0 || roomId == 1 || roomId == 2 ) {
            return true;
        }
        return false;

    }

    void pickupItem(int roomId)
    {
        switch (roomId) {
            case 0:
            {
                torch = true;
                break;
            }
            case 1: {
                potion = true;
                break;
            }
            case 2:{
                swordOfKings = true;
                break;
            }
        }

    }

}
