package codingFinalAlt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import creatingPeople.Dealer;
import creatingPeople.Players;

//Extends the JPanel Class (Find a different Purpose of this Class)
public class MenuPanel extends JPanel implements ActionListener{
	//initializing variable
	Dealer dealer = new Dealer("Mark");
	//JSwing Elements
	JLabel dealerName;
	JButton changeDealerName;
	JScrollPane scrollPane;
	JTextArea text;
	Color color = Color.orange;
	public String currentText = " ";
	
	
	public MenuPanel(int menuPanelWidth, int menuPanelHeight) {
		//setting the Panel
		this.setPreferredSize(new Dimension(menuPanelWidth, menuPanelHeight));
		this.setBackground(color);
		
		text = new JTextArea(14, 97);
		dealerName = new JLabel();
		changeDealerName = new JButton("Change dealer name?");
		dealerName.setText(dealer.firstName + " " + dealer.lastName);
		changeDealerName.setFocusable(false);
		changeDealerName.addActionListener(this);
		text.setBackground(Color.LIGHT_GRAY);
		text.setFont(new Font("Lexend", Font.PLAIN, 13));
		text.setForeground(color.BLUE);
		text.setEditable(false);
		scrollPane = new JScrollPane(text);
		scrollPane.setBounds(1, 1, 498, 349);
		
		
		this.add(dealerName);
		this.add(changeDealerName);
		this.add(scrollPane);
	}
	
	//Overridden Method
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == changeDealerName) {
			//Using JOption pane to get the player to reset the name
			String firstName = JOptionPane.showInputDialog("enter the dealers first name");
			String lastName = JOptionPane.showInputDialog("enter the dealers last name (leave blank if you don't want to add one)");
			if(lastName.equals(null)) {
				lastName = " ";
			}
			dealer.setFirstName(firstName);
			dealer.setLastName(lastName);
			if(lastName != " ") {
				dealerName.setText(dealer.firstName + " " + dealer.lastName);
			}else {
				dealerName.setText(dealer.firstName);
			}
		}
		
	}

}
