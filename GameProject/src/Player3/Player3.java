package Player3;

import java.util.ArrayList;

import link.Link;
//For designing player3 i use Builder design pattern.

public class Player3 implements Runnable{
	
	private ArrayList<Integer> card = new ArrayList<Integer>( );
	private int totalNumbersFound;
	private Link link;
	private int id;
	
	public Player3(ArrayList<Integer> card,Link link, int id) {
		this.card = card;
		this.id = id;
		this.link = link;
	}
	
	public void display() {
		System.out.println("The numbers in Player3 card are:");
		System.out.println(card);
	}
	
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
								link.successFlag[id] = true;						
							}
							
							// Sets the chance flag. 
							link.chanceFlag[id] = true;
							
							link.obj.notifyAll();
						}
					}
				}
		
		
	}

}
