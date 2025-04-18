package codingFinalAlt;

import java.awt.BorderLayout;

public class Main {
	
	public static void main(String args[]) {
		
		GameFrame frame = new GameFrame(1000, 700);
		
		GamePanel panel = new GamePanel(700, 500);
		//MenuPanel panelMenu = new MenuPanel(100, 100);
		
		frame.add(panel, BorderLayout.SOUTH);
		//frame.add(panelMenu, BorderLayout.NORTH);
		
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
