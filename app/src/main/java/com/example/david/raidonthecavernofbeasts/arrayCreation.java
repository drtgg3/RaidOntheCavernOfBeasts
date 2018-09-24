package com.example.david.raidonthecavernofbeasts;

    public class arrayCreation {

        int[][] completeArray = new int [4][6];
        int arrayCounter = 0;
        int currentRow = 0;
        int mapID = 0;
        int currentColumn = 0; {






            while (arrayCounter != 24)
            {
		/*we are giving each array a number to identify them later
		with, this will be helpful way down the line if I ever decide to
		make a visible map the players can see!*/
                completeArray[currentRow][currentColumn] = arrayCounter;
                arrayCounter +=1;
                currentColumn +=1;

                if(currentColumn == 6)
                {
                    currentColumn = 0;
                    currentRow +=1;
                }

            }

            currentRow = 0;
            currentColumn = 0;


        }

        //the movement options here already have some things in effect
        //to prevent moving out of bounds but I might have to do more
        // in the future for this feature to do more to let the user know
        //when in android studio.
        void moveEast()
        {
            if(currentColumn + 1 > 5)
            {
                System.out.println("You Hit a wall!");
            }

            else
            {
                currentColumn +=1;
                //for later we will need the map ID to trigger events
                //or the dialogue needed for that room so updating them
                //as we change them is key!
                mapID = completeArray[currentRow][currentColumn];
            }
        };

        void moveSouth()
        {
            if(currentRow + 1 > 3)
            {
                System.out.println("You hit a wall!");
            }

            else
            {
                currentRow +=1;
                mapID = completeArray[currentRow][currentColumn];
            }
        }

        void moveWest()
        {
            if(currentColumn - 1 < 0)
            {
                System.out.println("You hit a wall!");
            }

            else
            {
                currentColumn -=1;
                mapID = completeArray[currentRow][currentColumn];
            }
        }

        void moveNorth()
        {
            if(currentRow - 1 < 0)
            {
                System.out.println("You hit a wall!");
            }

            else
            {
                currentRow -=1;
                mapID = completeArray[currentRow][currentColumn];
            }
        }


    }

