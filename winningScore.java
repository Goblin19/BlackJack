package Awards;


public class winningScore implements Winnings{

	@Override
	public int Wonround(boolean bust) {
		if(bust == true) {
			return 0;
		}else {
			return 1000;
		}
	}
}
