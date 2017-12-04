package ClubManagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class LoginGUI extends JFrame {
	private Application app1;
	private User u1;
	
	private JButton OK;
	private JButton Back;
	
	private ArrayList<JButton> ClubButtons;
	
	public LoginGUI(String windowTitle, Application AnApp1, User aUser) 
	{   
		super(windowTitle);

		app1 = AnApp1;
		u1 = aUser;

		setSize(400, 300);
		
		setLocationRelativeTo(null);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(new JLabel("<HTML><center>Welcome to the Club Manager!!\n <BR> </HTML>"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}

	private void buildGUI() {
		// welcome message
		// view clubs
		// list clubs you are in (and responsibilities)
		// logout
		
		if(u1.getManagement().size() == 0) {
			JLabel clubLabel = new JLabel(" You are not in any clubs, would you like to join one?");
			this.add(clubLabel);
			
		}
		else {
		JLabel clubLabel = new JLabel("Clubs you are in:");
		
		//setLayout(new GridLayout(1, 1));  
		
		DefaultListModel<String> clubList = new DefaultListModel<>(); 
		
		for(int i = 0; i < u1.getManagement().size(); i++) {
			clubList.addElement(u1.getManagement().get(i).getClub().getName());
		}
		
		JSeparator sep = new JSeparator(); 
		this.add(sep);
		
		this.add(clubLabel);
		
		JSeparator sep2 = new JSeparator(); 
		this.add(sep2);
		
        JList<String> list = new JList<>(clubList);  
        list.setBounds(100,100, 75,75);  
        this.add(list);
        
        JButton logout = new JButton("logout");
        JButton viewClub = new JButton("View Club Page");
        JButton joinClubs = new JButton("Join a Club");
        
        this.add(viewClub);
        this.add(logout);
        this.add(joinClubs);
        
        logout.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				//u1 = null;
				// maybe set the user to null in all GUI's FIXME 
				//settings the user to null means they couldn't be added to events, don't do that
				System.exit(0);
			}
		});
        
        viewClub.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				String selected = list.getSelectedValue();
				ClubPageGUI newGUI = new ClubPageGUI(u1.getClub(selected).getClub(), u1);
			}
		});
        
        joinClubs.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				SearchClubs newGUI = new SearchClubs("Search", app1, u1);	
			}
		});
		}
		
	}
}