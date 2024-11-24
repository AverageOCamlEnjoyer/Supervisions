package uk.ac.cam.omb31.cyberpet;

public class Pet {
	public String name;
	public int hunger;
	public int boredom;
	public int tiredness;
	public boolean veryFull;
	public boolean veryExcited;
	public boolean veryTired;
	public boolean alive = true;
	public String deathReason = "";
	private int difficulty;
	
	public Pet() {
		hunger = 50;
		boredom = 50;
		tiredness = 50;
		difficulty = 3;
	}
	public void feed(){
		hunger -= 25;
		if (hunger < -20 || (hunger < 0 && veryFull)) {
			hunger = 0;
			deathReason = "Died from overfeeding";
			alive = false;
		} else if (hunger < 0) {
			veryFull = true;
			hunger = 0;
		} else {
			veryFull = false;
		}
		
	}
	public void play() {
		boredom -= 30;
		tiredness += 10;
		
		if (boredom < -25 || (boredom < 0 && veryFull)) {
			boredom = 0;
			deathReason = "Died from over excitation";
			alive = false;
		} else if (boredom < 0) {
			veryExcited = true;
			boredom = 0;
		} else {
			veryExcited = false;
		}
			
		
	}
	public void sleep() {
		tiredness = 0;
		hunger += 40;
		boredom += 60;
	}
	
	public void tick() {
		tiredness += (int) (Math.random() * difficulty);
		boredom += (int) (Math.random() * difficulty);
		hunger += (int) (Math.random() * difficulty);
		
		alive = false;
		if (hunger > 100) {
			deathReason = "Starved to death";
		} else if (boredom > 100) {
			deathReason = "Died from boredom";
		} else if (tiredness > 100) {
			deathReason = "Needed a rest...";
		} else {
			alive = true;
		}
	}
}
