package co.grandcircus;

public enum RoshVal {
	ROCK, PAPER, SCISSORS;
	public String toString() {
		switch (this) {
		case ROCK:
			return "Rock";
		case PAPER:
			return "Paper";
		case SCISSORS:
			return "Scissors";
		}
		return "This shouldn't return";
	}
}
