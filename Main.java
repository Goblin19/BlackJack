package codingFinalAlt;

public class Main {
	
	public static void main(String args[]) {
		
		GameFrame frame = new GameFrame();
		
		GamePanel panel = new GamePanel(700, 500);
		
		frame.add(panel);
		
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
