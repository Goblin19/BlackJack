package codingFinalAlt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import creatingPeople.Dealer;
import creatingPeople.Players;

//Extends the JPanel Class (Find a different Purpose of this Class)
public class MenuPanel extends JPanel{
	
	public MenuPanel(int menuPanelWidth, int menuPanelHeight) {
		//setting the Panel
		this.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
		this.setBackground(Color.blue);
		
	}


}
