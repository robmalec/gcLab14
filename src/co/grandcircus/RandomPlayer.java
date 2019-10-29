package co.grandcircus;

public class RandomPlayer extends Player {

	public RandomPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RoshVal generateRoshambo() {
		// TODO Auto-generated method stub
		switch ((int)Math.round(Math.random() * 2)) {
		case 0:
			return RoshVal.ROCK;
		case 1:
			return RoshVal.PAPER;
		case 2:
			return RoshVal.SCISSORS;
		}
		return null;
	}

}
