package ClubManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class SearchClubs extends JFrame{
	private Application app1;
	private User u1;
	
	private JButton OK;
	private JButton Back;
	
	private ArrayList<JButton> ClubButtons;
	
	public SearchClubs(String windowTitle, Application AnApp1, User aUser) 
	{   
		super(windowTitle);

		app1 = AnApp1;
		u1 = aUser;

		setSize(500, 500);
		
		setLocationRelativeTo(null);
		
		//setLayout(new FlowLayout(FlowLayout.LEFT));
		GridLayout Layout = new GridLayout(0,1);
		this.setLayout(Layout);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}

	private void buildGUI() {
		
		// go to club pages
		// logout
		
		JLabel clubLabel = new JLabel("Clubs you are not in:",SwingConstants.CENTER);
		clubLabel.setFont(new Font("Serif", Font.BOLD, 24));
		
		
		
		//setLayout(new GridLayout(0, 1));  
		
		DefaultListModel<String> clubList = new DefaultListModel<>(); 
		
		for(int i = 0; i < app1.getClubs().size(); i++) {
			if(!(u1.checkConflict(app1.getClubs().get(i)))) {
				clubList.addElement(app1.getClubs().get(i).getName());
			}
		}
		
		//JSeparator sep = new JSeparator(); 
		//this.add(sep);
		
		this.add(clubLabel);
		
		//JSeparator sep2 = new JSeparator(); 
		//this.add(sep2);
		
        JList<String> list = new JList<>(clubList);  
        //list.setBounds(100,0, 75,75);  
        this.add(list);
        
        JButton logout = new JButton("logout");
        JButton viewClub = new JButton("View Club Page");
        
        
        this.add(viewClub);
        this.add(logout);
        
        logout.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				u1 = null;
				// maybe set the user to null in all GUI's FIXME
				System.exit(0);
			}
		});
        
        viewClub.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				//u1 = null;
				// maybe set the user to null in all GUI's FIXME
				//System.exit(0);
				
			
			}
		});
		
	}
}
