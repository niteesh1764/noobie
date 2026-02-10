package snakenladder.entities;
import java.util.concurrent.ThreadLocalRandom;

public class Dice{
	private final int minValue;
	private final int maxValue;
	public Dice(int minValue, int maxValue){
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public int roll(){
		return ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
	}
}
