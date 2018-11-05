package com.example.david.raidonthecavernofbeasts;


public class eventManager {


        inventoryManager Item = new inventoryManager();
        int roomId = 0;

        String roomMove(int roomNumber)
        {
            roomId = roomNumber;

            switch (roomId)
            {
                case 0:
                    return room0();

                case 1:
                    return room1();

                case 2:
                    return room2();


                case 3:
                    return room3();


                case 4:
                    return room4();


                case 5:
                    return room5();


                case 6:
                    return room6();


                case 7:
                    return room7();


                case 8:
                    return room8();


                case 9:
                    return room9();


                case 10:
                    return room10();


                case 11:
                    return room11();


                case 12:
                    return room12();


                case 13:
                    return room13();


                case 14:
                   return room14();


                case 15:
                    return room15();


                case 16:
                    return room16();


                case 17:
                    return room17();


                case 18:
                    return room18();


                case 19:
                    return room19();


                case 20:
                    return room20();


                case 21:
                    return room21();


                case 22:
                    return room22();


                case 23:
                    return room23();

            }

            return "Invalid message";
        }



        String room0 ()
        {
            String roomDescription ="A large barren room with a single"
                    + "wooden door that seems to lead further in. Its "
                    + "old, decrepid and seems to have seen much better"
                    + " days.";

            if(!Item.torch)
            {
                return (roomDescription + "\n On the wall"
                        + " here there seems be an unlit and unused torch");
            }
            else
            {
              return (roomDescription);
            }

        }

        String room1()
        {
            String roomDescription = "this is room 1! no problems here!";

            if(!Item.potion) {
             return (roomDescription + "\n" + "there is an abandoned potion here too!");
            }

            return roomDescription;
        }

        String room2()
        {
            String roomDescription = "This is room 2! No problems here!";

            if (!Item.swordOfKings) {
            return (roomDescription + "\n" + "woah, a neat sword is laying here!");
            }

            return roomDescription;
        }

        String room3()
        {
            return "This is room 3! No problems here!";
        }

        String room4()
        {
            return "This is room 4! No problems here!";
        }

        String room5()
        {
            return "This is room 5! No problems here!";
        }


        String room6()
        {
            return "This is room 6! No problems here!";
        }


        String room7()
        {
            return "This is room 7! No problems here!";
        }


        String room8()
        {
            return "This is room 8! No problems here!";
        }


        String room9()
        {
            return "This is room 9! No problems here!";
        }

        String room10()
        {
            return "This is room 10! No problems here!";
        }


        String room11()
        {
            return "This is room 11! No problems here!";
        }

        String room12()
        {
            return "This is room 12! No problems here!";
        }

        String room13()
        {
            return"This is room 13! No problems here!";
        }

        String room14()
        {
            return "This is room 14! No problems here!";
        }

        String room15()
        {
            return "This is room 15! No problems here!";
        }

        String room16()
        {
            return "This is room 16! No problems here!";
        }

        String room17()
        {
           return "This is room 17! No problems here!";
        }

        String room18()
        {
           return "This is room 18! No problems here!";
        }

        String room19()
        {
            return "This is room 19! No problems here!";
        }

        String room20()
        {
           return "This is room 20! No problems here!";
        }

        String room21()
        {
            return "This is room 21! No problems here!";
        }

        String room22()
        {
            return "This is room 22! No problems here!";
        }

        String room23()
        {
            return "This is room 23! No problems here!";
        }

        char[] getSaveList (){
          return Item.saveList;
        }

        void sendSaveList(char[] saveList){
            Item.loadSaveList(saveList);
        }


}


