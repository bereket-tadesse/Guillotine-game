package application;

/**
 * A class for cards representing the persons in Guillotine game.
 * @author Bereket
 * @version 1.0
 */
public class Card{
	
	/** Stores the name of the perosn on the card*/
	private String name;
	
	/** Stores the group of the person on the card. */
	private String group;
	
	/** stores the point the card has. */
	private int point;
	
	/** stores true if the card has special point. */
	private boolean haveSpecialPoint = false;
	
	/**
	 * Creates a card with specified parameters.
	 * @param name name of the person on the card
	 * @param group group of the person on the card
	 * @param point the point the person has on the card
	 */
	public Card(String name, String group, int point) {
		this.name = name;
		this.group = group;
		this.point = point;
	}

	/**
	 * Creates a card with specified parameters.
	 * @param name name of the person on the card
	 * @param group group of the person on the card
	 * @param point the point the person has on the card
	 * @param haveSpecialPoint the boolean showing if the perosn card has special point.
	 */
	public Card(String name, String group, int point, boolean haveSpecialPoint) {
		this.name = name;
		this.group = group;
		this.point = point;
		this.haveSpecialPoint = haveSpecialPoint;
	}

	/**
	 * returns the name of the card 
	 * @return name name of the person on the card
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the person on the card 
	 * @param name stores the name of person on the card.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the group of the card. 
	 * @return the group of the person on the card
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * gets the point of the card
	 * @return the point of the card.
	 */
	public int getPoint() {
		return point;
	}
	
	/**
	 * determines if a card has special point.
	 * @return boolen value showing if card has special point
	 */
	public boolean getHaveSpecialPoint() {
		return haveSpecialPoint;
	}
	
	@Override
	public String toString() {
		
		if (haveSpecialPoint) {
			return this.getName() + ", " + this.getGroup() + ": *";
		} else {
			return this.getName() + ", " + this.getGroup() + ": " + this.getPoint();
		}
		
	}

	
}
