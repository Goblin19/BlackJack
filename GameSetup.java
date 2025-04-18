package codingFinalAlt;

import java.awt.BorderLayout;

public class GameSetup {

	public void GameRun() {
		GameFrame frame = new GameFrame(1000, 700);
		
		GamePanel panel = new GamePanel(1000, 350);
		MenuPanel panelMenu = new MenuPanel(1000, 350);
		
		frame.add(panel, BorderLayout.SOUTH);
		frame.add(panelMenu, BorderLayout.NORTH);
		
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		
	}

}
