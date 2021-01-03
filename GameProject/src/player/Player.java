package player;

import link.Link;

public class Player extends CreatePlayer implements Runnable  {
	
	private int id; // 0 for Player1, 1 for Player2, 2 for Player3.
	private int totalNumbersFound; // Act as counter for each for each loop. Through this we decide if player has won or not.
	private Link link; // To provide linking between player and moderator class.
	
	public Player(int id, Link link) { 			//Constructor for Player class.
		this.id = id;
		this.link = link;
	}
	
	
	@Override
	public int getTotalNumners() {
		return totalNumbersFound;
	}

	@Override
	public void run() {
		synchronized(link.obj) {			
					
			while(!link.gameCompletionFlag) {

						while(link.chanceFlag[id]) {
							try {
								link.obj.wait();
							} 
							catch (Exception e) {}
						}
						
							if(!link.gameCompletionFlag) {					
							
							for(int i = 0; i < 10; i++) {						
								if(link.announcedNumber == card.get(i)) {		//Checks announced number by moderator in players cards
									this.totalNumbersFound++;					   		
									
									break;
								}
							}
							
							if(this.totalNumbersFound == 3) {
								// Sets the success flag. 
								link.successFlag[this.id] = true;						
							}
							
							// Sets the chance flag. 
							link.chanceFlag[id] = true;
							
							link.obj.notifyAll();
						}
					}
				}
		
	}


	@Override
	public void display() {
			System.out.println("The numbers in Player "+(id+1)+" card are:");
			System.out.println(card);
		}
	
	
}
