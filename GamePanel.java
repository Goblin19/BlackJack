package codingFinalAlt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextArea;

import javax.swing.JPanel;


//class Game panel extends JPanel
public class GamePanel extends JPanel{
	//initializing variables
	public TextArea text;
	
	public GamePanel(int gamePanelWidth, int gamePanelHeight) {
		
		this.setPreferredSize(new Dimension(gamePanelWidth, gamePanelHeight));
		this.setBackground(Color.GREEN);
		
		//this.add(text);
	}
	
	

}
