package codingFinalAlt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import creatingPeople.Dealer;

//Extends the JPanel Class
public class MenuPanel extends JPanel implements ActionListener{
	//initializing variables
	private JMenu menu;
	private JMenuItem keepGoing;
	private JMenuItem renameDealer;
	Dealer dealer = new Dealer("John", "Brown");
	
	
	
	public MenuPanel(int menuPanelWidth, int menuPanelHeight) {
		//setting the Panel
		this.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
		this.setBackground(Color.black);
		
		
		//Menu setting
		renameDealer.addActionListener(this);
		keepGoing.addActionListener(this);
		menu.add(renameDealer);
		menu.add(keepGoing);
		this.add(menu);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object Source = e.getSource();
		
		if(Source == keepGoing) {
			
		}else if(Source == renameDealer) {
			String firstName = JOptionPane.showInputDialog("enter the Dealer's first name");
			String lastName = JOptionPane.showInputDialog("enter the Dealer's last name");
			if(lastName.equals(null)) {
				lastName = "";
			}
			dealer.setFirstName(firstName);
			dealer.setLastName(lastName);
		}
		
	}

}
