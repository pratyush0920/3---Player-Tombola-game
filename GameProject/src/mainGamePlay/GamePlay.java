package mainGamePlay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import Player3.Player3;
import Player3.Player3Builder;
import link.Link;
import moderator.Moderator;
import player.Player;

public class GamePlay {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// Below I use I/O, asking user to press 0 to start the game
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Press 0 to start the game.");
		int num1 = Integer.parseInt(br.readLine());
		
		//Below code shows various objects that are created.
		Link link = new Link();
		Moderator mod = Moderator.getInstance();
		mod.setLink(link);
		Player player1 = new Player(num1,link);		// Player1 and player2 are created using Player class.
		Player player2 = new Player(1,link);		
		Player3 player3 = new Player3Builder().setCard().setLink(link).setId().getPlayer3();    // player3 is created using PLayer3 class.
		
		//Generating random numbers between 0-50 and then passing to moderator.
		Random random = new Random();
		for(int i=0;i<10;i++) {
			mod.numbr.add(random.nextInt(51));
		}
		
		 player1.numberallotment(); 	// Generates random numbers of player 1.
		 player1.display();				// Displays numbers in card of player 1.
		 player2.numberallotment(); 	// Generates random numbers of player 1.
		 player2.display();         	// Displays numbers in card of player 2.
		 player3.display();				// Displays numbers in player3 card.
		 
		 Thread modThread  = new Thread(mod);
		 Thread player1Thread = new Thread(player1);
		 Thread player2Thread = new Thread(player2);
		 Thread player3Thread = new Thread(player3);
			
		 modThread. start();
		 player1Thread.start();
		 player2Thread.start();
		 player3Thread.start();
		 try {
			 modThread.join(); 	// to facilitate for moderator thred to first join, then after this main executes.
		 }
		 catch(Exception e) {}
		 
		 // Displays number of matches of respective players.
		 System.out.println("Number of matches of Player1 are:"+ player1.getTotalNumners());
		 System.out.println("Number of matches of Player2 are:"+ player2.getTotalNumners());
		 System.out.println("Number of matches of Player3 are:"+ player3.getTotalNumners());
		 
		 
		 // Checks who is the winner.

		 if(player1.getTotalNumners()==3 && player2.getTotalNumners()!=3 && player3.getTotalNumners()!=3) {
			 System.out.println("Player1 is winner.");
		 }
		 else  if(player2.getTotalNumners()==3 && player1.getTotalNumners()!=3 && player3.getTotalNumners()!=3) {
			 System.out.println("Player2 is winner.");
		 }
		 else if(player3.getTotalNumners()==3 && player2.getTotalNumners()!=3 && player1.getTotalNumners()!=3) {
			 System.out.println("Player3 is winner.");
		 }
		 else if(player1.getTotalNumners()==3 && player2.getTotalNumners()==3 && player3.getTotalNumners()!=3) {
			 System.out.println("Player1 and Player2 are winner.");
		 }
		 else if(player2.getTotalNumners()==3 && player3.getTotalNumners()==3 && player1.getTotalNumners()!=3) {
			 System.out.println("Player3 and Player2 are winner.");
		 }
		 else if(player3.getTotalNumners()==3 && player1.getTotalNumners()==3 && player2.getTotalNumners()!=3) {
			 System.out.println("Player1 and Player3 are winner.");
		 }
		 else if(player1.getTotalNumners()==3 && player2.getTotalNumners()==3 && player3.getTotalNumners()==3) {
			 System.out.println("All Player are winner.");
		 }
		 else {
			 System.out.println("No one wins.");
		 }
	}

}
