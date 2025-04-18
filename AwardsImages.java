package Awards;

import java.io.IOException;

import javax.imageio.ImageIO;

import codingFinalAlt.GamePanel;

public class AwardsImages {
	public Images[] ImageArray;
	public GamePanel gp;
	
	//Awards Images constructor
	public AwardsImages(GamePanel gp) {
		this.gp = gp;
		
		ImageArray = new Images[10];
		
		
	}
	
	public void getAwardImages() {
		try {
			ImageArray[1] = new Images();
			ImageArray[1].Image = ImageIO.read(getClass().getResourceAsStream("Filename"));
		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
