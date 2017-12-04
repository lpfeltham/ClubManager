package ClubManagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ClubPageGUI extends JFrame {
	private User u1;
	private President p1;
	private Officer o1;
	private Member m1;
	
	private Position pos1;
	
	private Club c1;
	
	
	public ClubPageGUI(Club club, User user) {
		
		super(club.getName());
		this.setSize(300, 300);
		
		u1 = user;
		c1 = club;
		
		this.setLayout(new BorderLayout());
		setVisible(true);
		
		switch(user.getClub(club.getName()).getPosition().getName()){
		case "Member":
			buildMemberGUI(club);
			break;
		case "Officer":
			buildOfficerGUI(club);
			break;
		case "President":
			buildPresidentGUI(club);
			break;
		}
	}

	private void buildMemberGUI(Club club) {
		JLabel placedLabel = new JLabel("  " + club.getName());
		JLabel placedDescription = new JLabel("  " + club.getDescription());
        JButton leave = new JButton("Leave Club");
        //JPanel panel = new JPanel();
   
        leave.setBackground(Color.RED);
        
        this.add(placedLabel, BorderLayout.NORTH);
        this.add(placedDescription);
        
        pos1 = u1.findMember(c1);
        
        this.add(leave, BorderLayout.SOUTH);
        
		// sign up action event listener
		leave.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void buildOfficerGUI(Club club) {
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel placedLabel = new JLabel(club.getName());
		JButton edit = new JButton("Edit Event");
		
		DefaultListModel<String> eventList = new DefaultListModel<>(); 
		DefaultListModel<String> optionsList = new DefaultListModel<>(); 
		
		setLocationRelativeTo(null);
        /*GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;*/
		
		for(int i = 0; i < c1.getEvents().size(); i++) {
			eventList.addElement(c1.getEvents().get(i).getName());
		}
		
		if(c1.getEvents().size() == 0) {
			eventList.addElement("NoEvents");
		}
		
		optionsList.addElement("Edit Event Schedule");
		optionsList.addElement("Edit Event Place");
		optionsList.addElement("Edit Event Name");
		
		JList<String> optionString = new JList<>(optionsList);
		JList<String> eventString = new JList<>(eventList);
		
		this.add(edit);
		
        pos1 = u1.findMember(c1);
        
        
        
	}
	
	private void buildPresidentGUI(Club club) {
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel placedLabel = new JLabel(club.getName());
		
		setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        JButton setDues = new JButton("Set Member Dues");
        JButton funds = new JButton("View Club Funds");
        
        panel.add(setDues, fieldGBC);
        panel.add(funds, fieldGBC);
        
        this.add(panel, BorderLayout.NORTH);
        
        pos1 = u1.findMember(c1);
	}
	
}