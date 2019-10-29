package co.grandcircus;

import java.util.Scanner;

public class RoshamboApp {
	static final int P1_NUM = 1, P2_NUM = 2, DRAW_NUM = 0;
	static Player p1 = new HumanPlayer();
	static Player p2 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int nextMove = 2;

		int totalGamesSinceLastReset = 0;
		int totalGames = 0;

		Boolean firstRun = true;

		// While loop
		while (nextMove != 4) {
			switch (nextMove) {
			case 1:
				// code to run a game
				int result = 0;
				while (result == 0) {
					result = runGame(p1.generateRoshambo(), p2.generateRoshambo());
					totalGames++;
					totalGamesSinceLastReset++;
					
					switch (result) {
					case P1_NUM:
						System.out.println("Player 1 wins!");
						p1.addWin();
						break;
					case P2_NUM:
						System.out.println("Player 2 wins!");
						p2.addWin();
						break;
					case DRAW_NUM:
						System.out.println("It's a draw!  Try again!");
						break;
					}
				}
				break;

			case 2:
				// code to edit player info
				p1.setName(Validator.getString(scn, "Enter Player 1 name: "));

				String p2Name = Validator.getString(scn, "Enter Player 2 name: ");

				switch (Validator.getInt(scn,
						"What type of player is player 2?\n1: another human\n2: a rock lover\n3: an AI\n")) {
				case 1:
					p2 = new HumanPlayer(p2Name);
					break;
				case 2:
					p2 = new RockPlayer(p2Name);
					break;
				case 3:
					p2 = new RandomPlayer(p2Name);
					break;
				}

				if (firstRun) {
					firstRun = false;
					nextMove = 1;
					continue;
				}
				break;

			case 3:
				p1.resetVicCounters();
				p2.resetVicCounters();
				totalGamesSinceLastReset = 0;
				break;
			case 4:
				break;
			default:
				System.out.println("That wasn't an option, try again");
				break;
			}

			// Logic should stop here if it doesn't need to be included in loop
			System.out.println();
			nextMove = Validator.getInt(scn, "What would you like to do?\n1. Play again\n2. Edit player info\n3. Reset victory/loss counter\n4. Quit\n");
		}

		// Indication that the program has ended
		System.out.println("Total wins and losses per player");
		System.out.println(p1.getName() + ": " + p1.getNumWins() + " wins and " + p1.getNumLosses() + " losses.");
		System.out.println(p2.getName() + ": " + p2.getNumWins() + " wins and " + p2.getNumLosses() + " losses.");
		System.out.println("Total games since last reset: " + totalGamesSinceLastReset);
		System.out.println("Total games in this program run (including draws): " + totalGames);
		System.out.println("");
		System.out.println("Goodbye.");
		scn.close();
	}

	/*
	 * Returns the player number of the victor of the match, either a 1 or a 2, or a
	 * 0 if it's a draw
	 */

	public static int runGame(RoshVal p1Move, RoshVal p2Move) {
		System.out.println(p1.getName() + "'s move: " + p1Move);
		System.out.println(p2.getName() + "'s move: " + p2Move);

		switch (p1Move) {
		case ROCK:
			switch (p2Move) {
			case ROCK:
				return DRAW_NUM;
			case PAPER:
				return P2_NUM;
			case SCISSORS:
				return P1_NUM;
			}
			break;
		case PAPER:
			switch (p2Move) {
			case ROCK:
				return P1_NUM;
			case PAPER:
				return DRAW_NUM;
			case SCISSORS:
				return P2_NUM;
			}
			break;
		case SCISSORS:
			switch (p2Move) {
			case ROCK:
				return P2_NUM;
			case PAPER:
				return P1_NUM;
			case SCISSORS:
				return DRAW_NUM;
			}
		}
		return DRAW_NUM;
	}
}
