package Player3;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import link.Link;

public class Player3Builder {
	
	private ArrayList<Integer> card = new ArrayList<Integer>( );
	private int id;
	private Link link;
	
	public Player3Builder setCard() {
		 for(int i=0;i<10;i++) {  
	    	 this.card.add(ThreadLocalRandom.current().nextInt(0,51));
	    }
		 
		return this;
	}
	
	public Player3Builder setLink(Link link) {
		this.link = link;
		return this;
	}
	
	public Player3Builder setId() {
		this.id = 2;
		return this;
	}
	
	public Player3 getPlayer3() {
		return new Player3(card,link,id);
	}

}
