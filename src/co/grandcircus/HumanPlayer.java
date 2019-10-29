package co.grandcircus;

import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer() {
		super();
	}
	
	public HumanPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RoshVal generateRoshambo() {
		// TODO Auto-generated method stub
		switch(Validator.getString(new Scanner(System.in), "What's " + super.getName() + "'s move?  (rock/paper/scissors)").toLowerCase()) {
		case "rock":
			return RoshVal.ROCK;
		case "paper":
			return RoshVal.PAPER;
		case "scissors":
			return RoshVal.SCISSORS;
		}
		return null;
	}

}
