package player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Here, I use template design pattern to design player class.
public abstract class CreatePlayer {
	public ArrayList<Integer> card = new ArrayList<Integer>( );
	public abstract void display();
	public abstract int getTotalNumners();
	
	public final void numberallotment() {
	    for(int i=0;i<10;i++) {  
	    	 card.add(ThreadLocalRandom.current().nextInt(0,51));
	    }
	}
	
}
