package ClubManagement;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InitialGUI extends JFrame{
	private Application app1;
	private User u1;
	public InitialGUI(String windowTitle, Application AnApp1, User aUser) 
	{   
		super(windowTitle);

		app1 = AnApp1;
		u1 = aUser;

		setSize(400, 300);
		
		setLocationRelativeTo(null);
		
		GridLayout Layout = new GridLayout(0,1);
		this.setLayout(Layout);
		
		JLabel Label = new JLabel("<HTML><center>Welcome to the Club Manager!!",SwingConstants.CENTER);
		this.add(Label);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}

	private void buildGUI() {
		// welcome message
		// view clubs
		// list clubs you are in (and responsibilities)
		// logout
		
		if(u1.getManagement().size() == 0) {
			JLabel clubLabel = new JLabel(" You are not in any clubs, would you like to join one?", SwingConstants.CENTER);
			this.add(clubLabel);
		}
			
			JButton logout = new JButton("logout");
			JButton joinClubs = new JButton("Join a Club");
			JButton viewClubs = new JButton("View Clubs");
			
			logout.setBackground(Color.RED);
			joinClubs.setBackground(Color.GREEN);
			
			this.add(joinClubs);
			this.add(viewClubs);
			this.add(logout);
			
			logout.addActionListener(new ActionListener() {	
        		public void actionPerformed(ActionEvent e) {
        			ClubGUI newGUI = new ClubGUI("ClubGUI", app1);	
        			dispose();
        		}
        	});
			joinClubs.addActionListener(new ActionListener(){	
        		public void actionPerformed(ActionEvent e) {
        			SearchClubs newGUI = new SearchClubs("Search", app1, u1);	
        		}
			});
			viewClubs.addActionListener(new ActionListener(){	
        		public void actionPerformed(ActionEvent e) {
        			LoginGUI newGUI = new LoginGUI("Welcome " + u1.getName(), app1, u1);	
        		}
			});
			
		}
}

