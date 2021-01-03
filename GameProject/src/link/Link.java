package link;

public class Link {
	
	public boolean gameCompletionFlag = false;	// Checks if the game is complete.
	public boolean successFlag[] = new boolean[3]; // Checks if player has won the game.
	public boolean chanceFlag[] = new boolean[3]; // Checks player has still chance to win the game.
	public Object obj = new Object();
	public Integer announcedNumber; // To pass the number to player to check if number matches.

}
