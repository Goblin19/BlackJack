package codingFinalAlt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import creatingPeople.Dealer;
import creatingPeople.Players;

//Class GameFrame extends JFrame
public class GameFrame extends JFrame implements ActionListener{
	private int count = 0;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem keepGoing;
	private JMenuItem renameDealer;
	private JMenuItem addPlayers;
	Dealer dealer = new Dealer("John", "Brown");
	Players[] players = new Players[count+1];
	
	public GameFrame(int Width, int Height) {
		
		this.setPreferredSize(new Dimension(Width, Height));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Testing");
		
		//Menu setting
		menuBar = new JMenuBar();
				
		menu = new JMenu("options");
				
		addPlayers = new JMenuItem("add Player?");
		renameDealer = new JMenuItem("rename Dealer?");
		keepGoing = new JMenuItem("Take turn?");
		addPlayers.addActionListener(this);
		renameDealer.addActionListener(this);
		keepGoing.addActionListener(this);
		menu.add(addPlayers);
		menu.add(renameDealer);
		menu.add(keepGoing);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Source of what button has been pressed
		Object Source = e.getSource();
		
		//checking which source has been used to be able to judge what to do
		if(Source == keepGoing) {
			
		}if(Source == renameDealer) {
			String firstName = JOptionPane.showInputDialog("enter the Dealer's first name");
			String lastName = JOptionPane.showInputDialog("enter the Dealer's last name");
			if(lastName.equals(null)) {
				lastName = "";
			}
			dealer.setFirstName(firstName);
			dealer.setLastName(lastName);
		}if(Source == addPlayers) {
			//Storing the player properly into the array
			String firstName = JOptionPane.showInputDialog("enter your first name");
			String lastName = JOptionPane.showInputDialog("enter your last name (leave blank if you don't want to add one)");
			if(lastName.equals(null)) {
				lastName = " ";
			}
			players[count] = new Players(firstName, lastName);
			
			
			//expand the array if neccisary
			if (count+1 == players.length) {
				Players[] tempArray = new Players[players.length+1];
				for (int i =0; i < players.length; i++) {
					tempArray[i] = players[i];
				}
				players = tempArray;
			}
		}
		
	}

}
