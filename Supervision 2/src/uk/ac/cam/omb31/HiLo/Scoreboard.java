package uk.ac.cam.omb31.HiLo;

import java.util.ArrayList;

public class Scoreboard {
	private ArrayList<String> scores = new ArrayList<String>();
	
	public void addScore(int guessesLeft, int difficulty, String name) {
		int score = guessesLeft * (difficulty * difficulty);
		scores.add(name + ": " + score);
	}
	
	public void displayScore() {
		for (String s : scores) {
			System.out.println(s);
		}
	}
}


