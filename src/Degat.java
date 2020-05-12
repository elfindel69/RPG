import java.util.concurrent.ThreadLocalRandom;

public interface Degat {
	
	
	public default int doDegats(int lDe,int lModif) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, lDe + 1);
		return randomNum + lModif;
		
	}

	
}
