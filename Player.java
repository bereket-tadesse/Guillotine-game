package application;

public class Player {

	/** the points the player collects */
	private int points = 0;
	
	/** the name of the player. */
	private String name;
	
	/** the list of collected cards */
	private LinkedList<Card> cardsCollected = new LinkedList<Card>();
	
	/** player turn boolean. */
	private boolean isPlayerTurn = false;

	/**
	 * Creates a player.
	 * @param player this player
	 */
	public Player(String player) {
		this.name = player;
	}
	/**
	 * gets player turn.
	 * @return boolean shwoing player turn
	 */
	public boolean isPlayerTurn() {
		return isPlayerTurn;
	}

	/**
	 * sets the player turn
	 * @param isPlayerTurn stores boolean for the player turn
	 */
	public void setPlayerTurn(boolean isPlayerTurn) {
		this.isPlayerTurn = isPlayerTurn;
	}

	/**
	 * gets the colllected cards.
	 * @return return the collected cards.
	 */
	public LinkedList<Card> getCardsCollected() {
		return cardsCollected;
	}

	/**
	 * gives the points collected by player.
	 * @return the points collected by the player.
	 */
	public int getPoint() {
		return points;
	}

	/**
	 * sets point collected.
	 * @param point the point of the player
	 */
	public void setPoint(int point) {
		this.points = point;
	}
	
	/**
	 * gives the name of the player.
	 * @return returns the name of the player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the player.
	 * @param name the name of the player.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
