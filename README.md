# Guillotine-game
Guillotine is a simple card game with the objective of collecting the most points. Players gain points by 'beheading' important nobles. It has JavaFX GUI and uses linkedlist as line of the players. feel free to use the source code and add more features and graphics.

## How to play the game 

At the start of the game, 20 "person" cards are placed in a line. The cards are selected and ordered randomly from the following cards.


Name	Group	Points
King Louis XIV	Royal	5
Marie Antoinette	Royal	5
Regent	Royal	4
Duke	Royal	3
Baron	Royal	3
Count	Royal	2 (4 if the player also collects the Countess)
Countess	Royal	2 (4 if the player also collects the Count)
Lord	Royal	2 (4 if the player also collects the Lady)
Lady	Royal	2 (4 if the player also collects the Lord)
Cardinal	Church	5
Archbishop	Church	4
Nun	Church	3
Bishop	Church	2
Priest	Church	1
Priest	Church	1
Heretic	Church	equal to the number of Church members the player collects
Governor	Civic	4
Mayor	Civic	3
Councilman	Civic	3
Judge	Civic	2
Judge	Civic	2
Tax Collector	Civic	equal to the number of Civic persons the player collects
Sheriff	Civic	1
Sheriff	Civic	1
Palace Guard	Military	equal to the number of Palace Guards the player collects
Palace Guard	Military	equal to the number of Palace Guards the player collects
Palace Guard	Military	equal to the number of Palace Guards the player collects
Palace Guard	Military	equal to the number of Palace Guards the player collects
Palace Guard	Military	equal to the number of Palace Guards the player collects
General	Military	4
Colonel	Military	3
Captain	Military	2
Lieutenant	Military	1
Lieutenant	Military	1
Tragic Figure	Commoner	worth -1 point for each Commoner the player collects
Heroic Figure	Commoner	-3
Student	Commoner	-1
Student	Commoner	-1
Student	Commoner	-1
Student	Commoner	-1

## Here are the possible actions a player can take prior to taking the card at the front of the line.

- Move the lead card back exactly 4 places.
- Move the lead card back exactly 3 places.
- Move the lead card back exactly 2 places.
- Move the lead card back exactly 1 place.
- Move the lead card to the end of the line.
- Move the last card of the line to the front.
- Reverse the entire line of cards.
- Reverse the first 5 cards of the line.
- Skip the turn (end the player's turn but don't take a card).
- Take the first card from the line (ends the player's turn).


# The game display has the following:

- The line of "person" cards the players can select.
- The available actions for each player.
- The "person" cards collected by each player.
- The current score for each player.

![image](https://github.com/bereket-tadesse/Guillotine-game/assets/84309246/cad13c53-3322-44fb-9602-0f1d80b39af6)

