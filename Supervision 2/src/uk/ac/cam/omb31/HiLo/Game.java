package uk.ac.cam.omb31.HiLo;

import java.util.Scanner;

public class Game {
	public int difficulty;
	private int rangeMax;
	private int rangeMin;
	private int guesses;
	private int number;
	private Scoreboard board = new Scoreboard();
	private String name;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Game game = new Game(1);
		game.setup();
		
		while (true) {

			game.start();
			System.out.println("Display Scoreboard? y/n");
			if (scan.nextLine().trim().equalsIgnoreCase("y")) {
				System.out.println("-------------------------");
				game.board.displayScore();
				System.out.println("-------------------------");
			}
			
			System.out.println("Change setup? y/n");
			if (scan.nextLine().trim().equalsIgnoreCase("y")) {
				game.setup();
			}
			
			System.out.println("-------------------------");
			
			
		}
	}
	private void setup() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name: ");
		name = scan.nextLine();
		System.out.println("Enter difficulty 1 -> 5: ");
		difficulty = scan.nextInt();
		setRange();
		setGuesses();
		rangeMin = 0;
		System.out.println("The number is between " + rangeMin + " " + rangeMax);
		System.out.println("You have " + guesses + " guesses");
	}
	
	
	private void start() {
		Scanner scan = new Scanner(System.in);
		
		number = (int) (Math.random() * rangeMax);
		System.out.println("Enter guess:");
		int remainingGuesses = guesses;
		while (remainingGuesses > 0) {
			int x = scan.nextInt();
			if (x<number) {
				System.out.println("Higher");
			} else if (x>number) {
				System.out.println("Lower");
			} else {
				System.out.println("Correct!");
				System.out.println("-------------------------");
				
				board.addScore(remainingGuesses, x, name);
				return;
			}
			remainingGuesses--;
		}
		System.out.println("You didn't guess it :(");
		System.out.println("The number was " + number);
		System.out.println("-------------------------");
		
	}
	
	public Game(int difficulty) {
		this.difficulty = Math.max(1, difficulty);
	}
	
	private void setRange() {
		this.rangeMax  = this.difficulty * 20;
	}
	private void setGuesses() {
		this.guesses  = Math.max(3,11 - difficulty);
	}

}
