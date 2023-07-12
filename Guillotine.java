package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A class of a game called Guillotine played by two players
 * @author Bereket
 * @version 1.0
 */
public class Guillotine extends Application {

	/** stores the number of cards the player */
	public static int NumberOfCards;
	
	/** Stores the array of buttons from the linked list of the cards. (used only fordisplaye purpose */
	public static Button[] ArrayOfButtonCards;
	
	/** stores player 1 */
	private static Player player1 = new Player("Player 1");
	
	/** stores player 2 */
	private static Player player2 = new Player("Player 2");
	
	/** stores the tile of player 1 */
	private static TilePane tilePlayer1 = new TilePane();
	
	/** stores the tile of cards */
	private static TilePane tileCards = new TilePane();
	
	/** stores the tile of player 2 */
	private static TilePane tilePlayer2 = new TilePane();
	
	/** displays the winner when game edns */
	private static Text winnerText = new Text();

	/**
	 * stores 20 cards which store the person represented in Guilltine Game. 
	 * The cards are made to be static since other helper methods access them.
	 */
	private static Card kingLouis = new Card("King Louis XIV", "Royal", 5);
	private static Card Marie = new Card("Marie Antoinette", "Royal", 5);
	private static Card regent = new Card("Regent", "Royal", 4);
	private static Card duke = new Card("Duke", "Royal", 3);
	private static Card baron = new Card("Baron", "Royal", 3);
	private static Card count = new Card("Count", "Royal", 2, true);
	private static Card countess = new Card("Countess", "Royal", 2, true); 
	private static Card lord = new Card("Lord", "Royal", 2, true); 
	private static Card lady = new Card("Lady", "Royal", 2, true); 
	private static Card cardinal = new Card("Cardinal", "Church", 5);
	private static Card archbishop = new Card("Archbishop", "Church", 4);
	private static Card nun = new Card("Nun", "Church", 3);
	private static Card bishop = new Card("Bishop", "Church", 2);
	private static Card priest = new Card("Priest", "Church", 1);
	private static Card priest2 = new Card("Priest", "Church", 1);
	private static Card heretic = new Card("Heretic", "Church", 0, true); 
	private static Card governor = new Card("Governor", "Civic", 4);
	private static Card mayor = new Card("Mayor", "Civic", 3);
	private static Card councilman = new Card("Councilman", "Civic", 3);
	private static Card judge = new Card("Judge", "Civic", 2);
	private static Card judge2 = new Card("Judge", "Civic", 2);
	private static Card taxCollector = new Card("Tax Collector", "Civic", 0, true);
	private static Card sheriff = new Card("Sheriff", "Civic", 1);
	private static Card sheriff2 = new Card("Sheriff", "Civic", 1);
	private static Card palaceGuard = new Card("Palace Guard", "Military", 0, true); 
	private static Card palanceGuard2 = new Card("Palace Guard", "Military", 0, true);
	private static Card palanceGuard3 = new Card("Palace Guard", "Military", 0, true); 
	private static Card palanceGuard4 = new Card("Palace Guard", "Military", 0, true); 
	private static Card palanceGuard5 = new Card("Palace Guard", "Military", 0, true); 
	private static Card general = new Card("General", "Military", 4);
	private static Card colonel = new Card("Colonel", "Military", 3);
	private static Card captain = new Card("Captain", "Military", 2);
	private static Card lieutenant = new Card("Lieutenant", "Military", 1);
	private static Card lieutenant2 = new Card("Lieutenant", "Military", 1);
	private static Card tragic = new Card("Tragic Figure", "Commoner", 0, true);
	private static Card heroic = new Card("Heroic Figure", "Commoner", -3);
	private static Card student = new Card("Student", "Commoner", -1);
	private static Card stundet2 = new Card("Student", "Commoner", -1);
	private static Card student3 = new Card("Student", "Commoner", -1);
	private static Card student4 = new Card("Student", "Commoner", -1);

	/*
	 * stores the cards in array to be extracted to a linked list using random
	 * function
	 */
	private static Card[] cardsList = { kingLouis, Marie, regent, duke, baron, count, countess, lord, lady, cardinal, archbishop, nun,
			bishop, priest, priest2, heretic, governor, mayor, councilman, judge, judge2, taxCollector, sheriff, sheriff2, palaceGuard,
			palanceGuard2, palanceGuard3, palanceGuard4, palanceGuard5, general, colonel, captain, lieutenant, lieutenant2, tragic, heroic, student, stundet2,
			student3, student4 };
	
	/** Stores the linked list of cards */
	private static LinkedList<Card> CardLinkedList = new LinkedList<Card>();

	/**
	 * gets player 1
	 * @return player1 payer 1 of the game
	 */
	public static Player getPlayer1() {
		return player1;
	}

	/**
	 * gets the player 2
	 * @return player2 player 2 of the game
	 */
	public static Player getPlayer2() {
		return player2;
	}

	/**
	 * sets player 2 of the game
	 * @param player2
	 */
	public static void setPlayer2(Player player2) {
		Guillotine.player2 = player2;
	}

	/**
	 * gets the number of initialised cards.
	 * @return NumberOfCards number of cards of the guilotine game
	 */
	public static int getNumberOfCards() {
		return NumberOfCards;
	}

	/**
	 * sets the numbre of cards of the game
	 * @param numberOfCards the num ber of catds to be set for the game.
	 */
	public static void setNumberOfCards(int numberOfCards) {
		NumberOfCards = numberOfCards;
	}

	/**
	 * A method which runs javafx gadgets when the game runs.
	 */
	public void start(Stage primarystage) {
		
		//Scanner object to allow input.
		Scanner reader = new Scanner(System.in);  
	    System.out.println("Enter Number of cards: ");
	    
	    //stores user input
	    String number = reader.nextLine();  

	    // Initialise the game with number of cards entered.
 		Guillotine.generateCards(Integer.parseInt(number));
	 		
		// player 1 starts the game by default.
		Guillotine.player1.setPlayerTurn(true);

		// stores the border pane. 
		BorderPane borderPane = new BorderPane();

		tilePlayer1.setPrefColumns(1);
		tileCards.setPrefColumns(1);
		tilePlayer2.setPrefColumns(1);

		Text scoreOfPlayer1 = new Text("Score: 0");
		Text scoreOfPlayer2 = new Text("Score: 0");

		// intializes the bittons of the player cards.
		Guillotine.updateArray();
		
		// Instatiating the action buttons for player 1.
		Button moveBack4 = new Button("Move Front Back 4");
		Button moveBack3 = new Button("Move Front Back 3");
		Button moveBack2 = new Button("Move Front Back 2");
		Button moveBack1 = new Button("Move Front Back 1");
		Button moveFronttoEnd = new Button("Move Front To End");
		Button moveLastToFront = new Button("Move Last Person To Front");
		Button reverseLine = new Button("Reverse Line");
		Button reverseFirst5 = new Button("Reverse First 5");
		Button skipTurn = new Button("Skip Turn");
		Button takeFrontPerson = new Button("Take Front Person");

		// moves the card 4 unit back ward 
		moveBack4.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(4);
				Guillotine.updateArray();
				moveBack4.setDisable(true);
			}
		});

		// moves the card 3 unit back ward 
		moveBack3.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(3);
				Guillotine.updateArray();
				moveBack3.setDisable(true);
			}
		});

		// moves the card 2 unit back ward 
		moveBack2.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(2);
				Guillotine.updateArray();
				moveBack2.setDisable(true);
			}
		});
		// moves the card 1 unit back ward 
		moveBack1.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(1);
				Guillotine.updateArray();
				moveBack1.setDisable(true);
			}
		});
		// moves the front card to end 
		moveFronttoEnd.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveFirstToLast();
				Guillotine.updateArray();
				moveFronttoEnd.setDisable(true);
			}
		});
		// moves the last card to front 
		moveLastToFront.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveLastToFIrst();
				Guillotine.updateArray();
				moveLastToFront.setDisable(true);
			}
		});

		// reverses the card line 
		reverseLine.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.reverseList();
				Guillotine.updateArray();
				reverseLine.setDisable(true);
			}
		});
		// reverses the first 5 cards 
		reverseFirst5.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.CardLinkedList.reverseFirstK(5);
				Guillotine.updateArray();
				reverseFirst5.setDisable(true);
			}
		});
		// skips the turn of the player 
		skipTurn.setOnAction(e -> {
			if (Guillotine.player1.isPlayerTurn()) {
				Guillotine.player1.setPlayerTurn(false);
				Guillotine.player2.setPlayerTurn(true);
			}
		});

		// take the first card and add it to collected persons 
		takeFrontPerson.setOnAction(e -> {

			if (Guillotine.player1.isPlayerTurn() && !Guillotine.CardLinkedList.isEmpty()) {

				// stores removed card
				Card removedCard = Guillotine.CardLinkedList.removeFromFront();
				tilePlayer1.getChildren().add(new Button(removedCard.toString()));
				Guillotine.updateArray();

				// checking if it is special card with a special point.
				if (removedCard.getHaveSpecialPoint())  
					Guillotine.player1.setPoint(Guillotine.player1.getPoint() + Guillotine.specialPointCalculator(removedCard, Guillotine.player1));
				  else 
					Guillotine.player1.setPoint(Guillotine.player1.getPoint() + removedCard.getPoint());
				
				Guillotine.player1.getCardsCollected().addToEnd(removedCard);

				// updating score display
				scoreOfPlayer1.setText("Score: " + Guillotine.player1.getPoint());
				
				// setplayer turn.
				Guillotine.player1.setPlayerTurn(false);
				Guillotine.player2.setPlayerTurn(true);
				
				// checks if game has ended and display winner.
				if (Guillotine.CardLinkedList.isEmpty()){
					Guillotine.checkWinner();
				}

			}

		});

		// instantiating the buttons for player 2.
		Button moveBack4Player2 = new Button("Move Front Back 4");
		Button moveBack3Player2 = new Button("Move Front Back 3");
		Button moveBack2Player2 = new Button("Move Front Back 2");
		Button moveBack1Player2 = new Button("Move Front Back 1");
		Button moveFronttoEndPlayer2 = new Button("Move Front To End");
		Button moveLastToFrontPlayer2 = new Button("Move Last Person To Front");
		Button reverseLinePlayer2 = new Button("Reverse Line");
		Button reverseFirst5Player2 = new Button("Reverse First 5");
		Button skipTurnPlayer2 = new Button("Skip Turn");
		Button takeFrontPersonPlayer2 = new Button("Take Front Person");

		// moves the card 4 unit back ward 
		moveBack4Player2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(4);
				Guillotine.updateArray();
				moveBack4Player2.setDisable(true);
			}
		});
		
		// moves the card 3 unit back ward 
		moveBack3Player2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(3);
				Guillotine.updateArray();
				moveBack3Player2.setDisable(true);
			}
		});
		
		// moves the card 2 unit back ward 
		moveBack2Player2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(2);
				Guillotine.updateArray();
				moveBack2Player2.setDisable(true);
			}
		});
		
		// moves the card 1 unit back ward 
		moveBack1Player2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveBack(1);
				Guillotine.updateArray();
				moveBack1Player2.setDisable(true);
			}
		});
		
		// moves the front card to end 
		moveFronttoEndPlayer2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveFirstToLast();
				Guillotine.updateArray();
				moveFronttoEndPlayer2.setDisable(true);
			}
		});
		
		// moves the last card to front 
		moveLastToFrontPlayer2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.moveLastToFIrst();
				Guillotine.updateArray();
				moveLastToFrontPlayer2.setDisable(true);
			}
		});
		
		// reverses the card line 
		reverseLinePlayer2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.reverseList();
				Guillotine.updateArray();
				reverseLinePlayer2.setDisable(true);
			}
		});
		
		// reverses the first 5 cards 
		reverseFirst5Player2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.CardLinkedList.reverseFirstK(5);
				Guillotine.updateArray();
				reverseFirst5Player2.setDisable(true);
			}
		});
		
		// skips the turn of the player 
		skipTurnPlayer2.setOnAction(e -> {
			if (Guillotine.player2.isPlayerTurn()) {
				Guillotine.player2.setPlayerTurn(false);
				Guillotine.player1.setPlayerTurn(true);
			}
		});
		
		// take the first card and add it to collected persons 
		takeFrontPersonPlayer2.setOnAction(e -> {
			
			if (Guillotine.player2.isPlayerTurn() && !Guillotine.CardLinkedList.isEmpty()) {
				
				// stores removed card
				Card removedCard = Guillotine.CardLinkedList.removeFromFront();
				tilePlayer2.getChildren().add(new Button(removedCard.toString()));
				Guillotine.updateArray();

				// checking if it is special card with a special point.
				if (removedCard.getHaveSpecialPoint()) 
					Guillotine.player2.setPoint(Guillotine.player2.getPoint() + Guillotine.specialPointCalculator(removedCard, Guillotine.player2));
				else 
					Guillotine.player2.setPoint(Guillotine.player2.getPoint() + removedCard.getPoint());

				Guillotine.player2.getCardsCollected().addToEnd(removedCard);

				// updating score display
				scoreOfPlayer2.setText("Score: " + Guillotine.player2.getPoint());

				// Set player turn.
				Guillotine.player2.setPlayerTurn(false);
				Guillotine.player1.setPlayerTurn(true);
				
				// checks if game has ended and display winner.
				if (Guillotine.CardLinkedList.isEmpty()){
					Guillotine.checkWinner();
				}

			}

		});

		// aAdding the action buttons on border pane.
		tilePlayer1.getChildren().add(new Text(Guillotine.player1.getName()));
		tilePlayer1.getChildren().add(scoreOfPlayer1);
		tilePlayer1.getChildren().add(moveBack4);
		tilePlayer1.getChildren().add(moveBack3);
		tilePlayer1.getChildren().add(moveBack2);
		tilePlayer1.getChildren().add(moveBack1);
		tilePlayer1.getChildren().add(moveFronttoEnd);
		tilePlayer1.getChildren().add(moveLastToFront);
		tilePlayer1.getChildren().add(reverseLine);
		tilePlayer1.getChildren().add(reverseFirst5);
		tilePlayer1.getChildren().add(skipTurn);
		tilePlayer1.getChildren().add(takeFrontPerson);
		tilePlayer1.getChildren().add(new Text("People Collected"));

		// adding the action buttons for player 2 
		tilePlayer2.getChildren().add(new Text(Guillotine.player2.getName()));
		tilePlayer2.getChildren().add(scoreOfPlayer2);
		tilePlayer2.getChildren().add(moveBack4Player2);
		tilePlayer2.getChildren().add(moveBack3Player2);
		tilePlayer2.getChildren().add(moveBack2Player2);
		tilePlayer2.getChildren().add(moveBack1Player2);
		tilePlayer2.getChildren().add(moveFronttoEndPlayer2);
		tilePlayer2.getChildren().add(moveLastToFrontPlayer2);
		tilePlayer2.getChildren().add(reverseLinePlayer2);
		tilePlayer2.getChildren().add(reverseFirst5Player2);
		tilePlayer2.getChildren().add(skipTurnPlayer2);
		tilePlayer2.getChildren().add(takeFrontPersonPlayer2);
		tilePlayer2.getChildren().add(new Text("People Collected"));

		borderPane.setLeft(tilePlayer1);
		borderPane.setCenter(tileCards);
		borderPane.setRight(tilePlayer2);
		Scene myscene = new Scene(borderPane, 520, 630);
		primarystage.setScene(myscene);
		primarystage.show();

	}

	/**
	 * A emthod which genrates the cards in a linked list.
	 * @param n the number of cards to be gnerated.
	 */
	public static void generateCards(int n) {

		// sets the number of cards
		Guillotine.setNumberOfCards(n);
		Guillotine.ArrayOfButtonCards = new Button[n];

		// stores random class
		Random rand = new Random();
		
		// stores the used indexes of cards
		int[] usedIndexOfCards = new int[n];

		int randNo;

		// loops n times geenrating the linked list.
		for (int i = 0; i < n; i++) {
			randNo = rand.nextInt(39);
			usedIndexOfCards[i] = randNo;
			
			while (Arrays.asList(usedIndexOfCards).contains(randNo)) {
				randNo = rand.nextInt(39);
			}
			CardLinkedList.addToEnd(cardsList[randNo]);
		}
	}

	/**
	 * A method to update the diplay of the cards in the middle tile pane.
	 */
	public static void updateArray() {

		// stores the curren node in the linked list of cards 
		LLNode<Card> current = Guillotine.CardLinkedList.getFirstNode();
		tileCards.getChildren().clear();

		// loops through and intialise the liked list of cards 
		for (int i = 0; i < Guillotine.CardLinkedList.length(); i++) {
			Guillotine.ArrayOfButtonCards[i] = new Button(current.getElement().toString());
			tileCards.getChildren().add(Guillotine.ArrayOfButtonCards[i]);
			current = current.getNext();

		}

	}

	/**
	 * A method to calculates the special card points based on the instruction.
	 * @param card   card which has special point
	 * @param player the player playing the card
	 * @return the calculated point.
	 */
	public static int specialPointCalculator(Card card, Player player) {

		// stores specific card counter
		int count = 0;

		LLNode<Card> current = player.getCardsCollected().getFirstNode();
		
		//loops through the collected card array
		while (current != null) {

			if (card.getName().equals("Count") && current.getElement().getName().equals("Countess")) {
				return 4;
			} else if (card.getName().equals("Countess") && current.getElement().getName().equals("Count")) {
				return 4;
			} else if (card.getName().equals("Lord") && current.getElement().getName().equals("Lady")) {
				return 4;
			} else if (card.getName().equals("Lady") && current.getElement().getName().equals("Lord")) {
				return 4;
			}
			else if (card.getName().equals("Heretic") && current.getElement().getGroup().equals("Church")) {
				count++; // count by group
			}
			else if (card.getName().equals("Tax Collector") && current.getElement().getGroup().equals("Civic")) {
				count++; // count by group
			} else if (card.getName().equals("Palace Guard") && current.getElement().getName().equals("Palace Guard")) {
				count++;
			} else if (card.getName().equals("Tragic Figure") && current.getElement().getGroup().equals("Commoner")) {
				count--;
			}
			current = current.getNext();
		}
		return count;
	}

	/**
	 * A method which identifies the winner.
	 */
	public static void checkWinner() {

		// Displayers the winner of the game.
		if (Guillotine.CardLinkedList.isEmpty()) {
			if (Guillotine.player1.getPoint() > Guillotine.player2.getPoint()) {
				winnerText.setText("Winner is: " + player1.getName());
			} else if (Guillotine.player2.getPoint() > Guillotine.player1.getPoint()) {
				winnerText.setText("Winner is: " + player2.getName());
			} else {
				winnerText.setText("Try again");
			}
			Guillotine.tileCards.getChildren().add(winnerText);
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}
	
}
