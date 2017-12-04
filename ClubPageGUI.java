package ClubManagement;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClubPageGUI extends JFrame {
	
	public ClubPageGUI(Club club, User user) {
		super(club.getName());
		this.setSize(300, 300);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
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
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel placedLabel = new JLabel(club.getName());
		
		setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        JButton leave = new JButton("Leave Club");
        panel.add(leave);
        
        this.add(panel, BorderLayout.NORTH);
        
	}
	
	private void buildOfficerGUI(Club club) {
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel placedLabel = new JLabel(club.getName());
		
		setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        
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
	}
	
}