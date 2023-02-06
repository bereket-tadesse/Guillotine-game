package application;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A class to test Guillotin game containig Card, Player and LinkedList class.
 * @author Bereket
 * @version 1.0
 */
public class GuillotineJUnit {

	/**
	 * Testing the 5 methods added to LinkedList from the instruction. 
	 * Only test 0,1 and many are used since the linkedlist doesnot use for loop and test first middle last has no meaning.
	 */
	@Test
	public void moveBackTester() {
		
		LinkedList<Integer> list1 = new LinkedList();
		list1.addToEnd(9);
		list1.addToEnd(10);
		list1.addToEnd(4);
		list1.addToEnd(6);
		
		list1.moveBack(0);
		assertEquals(" 9 10 4 6", LinkedList.printList(list1) );  //Test 0
		
		list1.moveBack(1);
		assertEquals(" 10 9 4 6", LinkedList.printList(list1)); // Test 1
		
		list1.moveBack(3);
		assertEquals(" 9 4 6 10", LinkedList.printList(list1)); // Tets many
	
	}
	
	/**
	 * A method to test moveFirstToLast
	 */
	@Test
	public void moveFirstToLastTester() {
		
		LinkedList<Integer> list1 = new LinkedList();
		
		list1.moveFirstToLast();  
		assertEquals("", LinkedList.printList(list1)); // Test 0
		
		list1.addToEnd(3);
		list1.moveFirstToLast();  
		assertEquals(" 3", LinkedList.printList(list1)); // Test 1
		
		list1.addToEnd(7);
		list1.addToEnd(4);
		assertEquals(" 3 7 4", LinkedList.printList(list1)); // Test many
	
	}
	
	
	/**
	 * A method to test reverseList
	 */
	@Test 
	public void reverseListTester() {
		
		LinkedList<Integer> list1 = new LinkedList();
		
		list1.reverseList();  
		assertEquals("", LinkedList.printList(list1)); // Test 0
		
		list1.addToEnd(7);
		list1.reverseList();  
		assertEquals(" 7", LinkedList.printList(list1)); // Test 1
		
		list1.addToEnd(3);
		list1.addToEnd(2);
		list1.addToEnd(4);
		list1.addToEnd(2);
		list1.reverseList();
		assertEquals(" 2 4 2 3 7", LinkedList.printList(list1));  // Test many
		
	}
	
	/**
	 * A method to test reverseListK
	 */
	@Test 
	public void reverseListKTester() {
		
		LinkedList<Integer> list1 = new LinkedList();
		
		list1.reverseFirstK(0);  
		assertEquals("", LinkedList.printList(list1)); // Test 0
		
		list1.addToEnd(9);
		list1.reverseFirstK(1);  
		assertEquals(" 9", LinkedList.printList(list1)); // Test 1
		
		list1.addToEnd(4);
		list1.addToEnd(1);
		list1.addToEnd(3);
		list1.addToEnd(2);
		list1.reverseFirstK(3);
		assertEquals(" 1 4 9 3 2", LinkedList.printList(list1));  // Test many
		
	}
	
	/**
	 * A method to test moveLastToFirst
	 */
	@Test 
	public void moveLastToFirstTester() {
		
		LinkedList<Integer> list1 = new LinkedList();
		
		list1.moveLastToFIrst();  
		assertEquals("", LinkedList.printList(list1)); // Test 0
		
		list1.moveLastToFIrst();  
		assertEquals("", LinkedList.printList(list1)); // Test 1
		
		list1.addToEnd(3);
		list1.addToEnd(2);
		list1.addToEnd(4);
		list1.addToEnd(2);
		assertEquals(" 3 2 4 2", LinkedList.printList(list1));  // Test many
		
	}
	
	/**
	 * Tests the player class getter and setters
	 */
	public void playerClassTester() {
		
		Player player1 = new Player("David");
		player1.setPoint(30);
		player1.setPlayerTurn(true);
		
		// testing getter and setters
		assertEquals("David", player1.getName());   //Test getname
		assertEquals(true, player1.isPlayerTurn());   //Test is	playerturn
		assertEquals(30, player1.getPoint());        //test getpoint
		
	}
	
	/**
	 * tests the card class getter and setters.
	 */
	public void cardClassTester() {
		
		Card mycard = new Card("Colonel", "Military" , 4, false);
		
		//testing the getter and setters
		assertEquals("Colonel", mycard.getName());    //Test getname
		assertEquals("Military", mycard.getGroup());   //Test getgroup
		assertEquals(4, mycard.getPoint()); 			//Test get point
		assertEquals(false, mycard.getHaveSpecialPoint());    //test havespecialpoint
		
	}
	
}
