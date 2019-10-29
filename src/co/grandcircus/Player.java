package co.grandcircus;

public abstract class Player {
	private String name = "";
	private int numWins = 0;
	private int numLosses = 0;
	
	public Player(String name) {
		this.name = name;
	}
	public Player() {}
	public abstract RoshVal generateRoshambo();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addWin() {
		numWins++;
	}
	public void addLoss() {
		numLosses++;
	}
	public int getNumWins() {return numWins;}
	public int getNumLosses() {return numLosses;}
	public void resetVicCounters() {
		numWins = 0;
		numLosses = 0;
	}
	
	
}
