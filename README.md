# Basketball Stat Tracker

## New upcoming app that will be implemented in the NBA starting tomorrow

### Overview of my project

- What will the application do?

The application will take in a basketball player with a name, age, height, and weight (this can be updated).
the application will also take in the amount of points made per game, steals, blocks, and assists.
The application will calculate a players average points per games overall, and the highest points ever recorded.
Will display a board with the top players and their stats. 

- who will use it?

The *NBA*, *ESPN*, **UBC** intramural leagues, or anyone looking to keep a record of their players and how they are doing.

- Why is this project of interest to me?

This project is interesting, because I have played lots of sports, and even ended up on some rankings before.
I thought it would be pretty cool if I could make my own system around how these stats are tracked. 




## User Stories

- As a user, I want to be able to add and remove a new player that has been put into the list of players
- As a user, I want to be able to add points to the total amount of points, steals, blocks a player has after they play each game
- As a user, I want to be able to be able to get the highest amount, and the average amount of points,blocks,assists that a player has gotten out of all their games
- As a user, I want to be able to view the list of all players in the listOfPlayers.
- As a user, I want to be able to save my basketball stat tracker in the file if I so choose 
- As a user, I want to be able to be able to load my basketball stat tracker if I choose to


# Instructions for Grader

- after first running the main method, there will be 5 buttons on the screen. Add, remove, load, save and display.
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking the 'add player' button, and typing in the players name, age, width, and height.
- You can generate the second required action related to the user story "removing Xs from Y" by clicking 'remove player' button, entering their names, to remove the player
- You can locate my visual component by looking at the pictureIcon function and finding visual in downloads
- You can save the state of my application by clicking the save button
- You can reload the state of my application by clicking the load button


# Phase 4: task 2

Sun Apr 07 16:57:22 PDT 2024
Added b to the tracker
Sun Apr 07 16:57:22 PDT 2024
Added c to the tracker
Sun Apr 07 16:57:30 PDT 2024
Added a to the tracker
Sun Apr 07 16:57:34 PDT 2024
Removed b from the tracker
Sun Apr 07 16:57:40 PDT 2024
Added qwer to the tracker
Sun Apr 07 16:57:44 PDT 2024
Added asd to the tracker
Sun Apr 07 16:57:51 PDT 2024
Added g to the tracker
Sun Apr 07 16:57:59 PDT 2024
Removed g from the tracker


# Phase 4: Task 3

In my UI, there are a lot of repeated panel classes, which do very similar things. For such classes, especially if I
wanted to implement more functionality, would be difficult to do now. To refactor, I would add abstract classes, and a couple of 
interfaces to group the methods together, and get rid of duplicated code. This will make debugging easier in the future as well. 
When I was writing the code for some of these panels, there were a couple of bugs wrong with each class that I did not catch
until I was running the program. This caused me to have to go back and change each class, which was only doable with a smaller amount
of classes, which I had. Having an abstract class would make this process much easier and efficient. 