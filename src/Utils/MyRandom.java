package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class MyRandom {
	private int min;
	private int max;
	
	public MyRandom(int lMin, int lMax) {
		this.min = lMin;
		this.max = lMax;
	}
	
	public int randomize() {
		int result = ThreadLocalRandom.current().nextInt(min, max+1);
		return result;
	}
}
