package sounds;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


//Class for sound
public class Audio {
	//Audio
	Clip clip;
	URL soundURL[] = new URL[1];

		public Audio() {
			soundURL[0] = getClass().getResource("GameShowBackground.wav");
			
		}
		
		public void getClip(int i) {
			
			try {
				AudioInputStream Audio = AudioSystem.getAudioInputStream(soundURL[i]);
				clip = AudioSystem.getClip();
				clip.open(Audio);
				
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		
		public void play() {
			clip.start();
		}
		
		public void loop() {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		
		public void stop() {
			clip.stop();
		}
		
		public void soundEffect(int i) {
			getClip(i);
			play();
		}
		
		public void backgroundSound(int i) {
			getClip(i);
			play();
			loop();
		}
	

}
