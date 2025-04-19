package Awards;

import java.util.Random;

public class ImageAward implements Winnings {
	Random image;
	
	@Override
	public int Wonround(boolean bust) {
		image = new Random();
		if(bust == false) {
			int rng = image.nextInt(1,5);
			int rngMoney = rng * 100;
			return rngMoney;
		}else {
			return 0;
		}
	}
	
	

}
