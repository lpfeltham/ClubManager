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
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ClubPageGUI extends JFrame {
	
	private User u1;
	private Event e1;
	private Position pos1;
	private Club c1;
	private Application app1;
	
	public ClubPageGUI(Club club, User user, Application app) {
		
		super(club.getName());
		this.setSize(300, 300);
		
		u1 = user;
		c1 = club;
		e1 = new Event();
		app1 = app;
		
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
		JLabel placedLabel = new JLabel("  Welcome to " + club.getName());
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
		//JPanel panel = new JPanel(new GridBagLayout());
		JLabel placedLabel = new JLabel("  Welcome to " + club.getName());
		JLabel placedDescription = new JLabel("  " + club.getDescription());
		JButton edit = new JButton("Edit Event");
		
		//this.add(placedLabel);
		//this.add(placedDescription);
		
		DefaultListModel<String> eventList = new DefaultListModel<>(); 
		DefaultListModel<String> optionsList = new DefaultListModel<>(); 
		
		setLocationRelativeTo(null);
		
		for(int i = 0; i < c1.getEvents().size(); i++) {
			eventList.addElement("<HTML><B>" + c1.getEvents().get(i).getName() + 
					"</B><BR>" + c1.getEvents().get(i).getPlace().getAddress() +
					"<BR>" + c1.getEvents().get(i).getSchedule().getScheduleString() +
					"</HTML>");
		}
		
		if(c1.getEvents().size() == 0) {
			eventList.addElement("NoEvents");
		}
		
		optionsList.addElement("Edit Event Schedule");
		optionsList.addElement("Edit Event Place");
		optionsList.addElement("Edit Event Name");
		
		JList<String> optionString = new JList<>(optionsList);
		JList<String> eventString = new JList<>(eventList);
		
		this.add(edit, BorderLayout.SOUTH);
		this.add(optionString, BorderLayout.WEST);
		this.add(eventString, BorderLayout.EAST);
		this.add(placedLabel, BorderLayout.NORTH);
		
        pos1 = u1.findMember(c1);
        
		// sign up action event listener
		edit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String selectedFunction = optionString.getSelectedValue();
				String selectedEvent = eventString.getSelectedValue();
				//Event e1 = new Event();
				
				for(int i = 0; i < c1.getEvents().size(); i++) {
					if(c1.getEvents().get(i).getName().equals(selectedEvent)) {
						e1 = c1.getEvents().get(i);
					}
				}
				
				if(selectedFunction.equals("Edit Event Schedule")) {
					// Generate edit event schedule
					
				}
				else if(selectedFunction.equals("Edit Event Place")) {
					buildEditEventPlace();
				}
				else {
					// Generate edit event name
					 buildEditEventName();	
				}
			}
		});
        
	}
	
	private void buildPresidentGUI(Club club) {
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel placedLabel = new JLabel("  Welcome to " + club.getName());
		
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
	
	private void buildEditEventName() {
		JFrame frame = new JFrame("Edit Event Name");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel newNameLabel = new JLabel("New Name for " + e1.getName() + ":");
		JTextField newNameField = new JTextField(10);
		
		// les buttons
		JButton edit = new JButton("Edit");
		JButton cancelButton = new JButton("Cancel");
		
        frame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(newNameLabel, labelGBC);
        panel.add(newNameField, fieldGBC);
        
        panel.add(edit);
		panel.add(cancelButton);
		
		frame.add(panel, BorderLayout.NORTH);
		
		frame.setVisible(true);
		
		// cancel button closes window
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		});
		
		edit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				e1.setName(newNameField.getText());
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		});
	}
	
	private void buildEditEventPlace() {
		JFrame frame = new JFrame("Edit Event Place");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel newNameLabel = new JLabel("New Place for " + e1.getName() + ":");
		JTextField newNameField = new JTextField(10);
		
		// les buttons
		JButton edit = new JButton("Edit");
		JButton cancelButton = new JButton("Cancel");
		
        frame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(newNameLabel, labelGBC);
        panel.add(newNameField, fieldGBC);
        
        panel.add(edit);
		panel.add(cancelButton);
		
		frame.add(panel, BorderLayout.NORTH);
		
		frame.setVisible(true);
		
		// cancel button closes window
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		});
		
		// cancel button closes window
		edit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(app1.doesPlaceExist(newNameField.getText()) == false) {
					buildWarningGUI("Error " + newNameField.getText() +
							" does not exist.", "Error");
				}
				else {
					Place p1 = app1.getPlace(newNameField.getText());
					
					if(p1.detectScheduleConflict(e1.getSchedule()) == true) {
						buildWarningGUI("Error schedule conflict", "Error");
					}
					else {
						e1.setPlace(p1);
						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					}
				}
			}	
		});
		
	}
	
	private void buildEditEventSchedule() {
		
	}
	
	private void buildWarningGUI(String printText, String titleText) {
		JFrame warning = new JFrame(titleText);
		warning.setSize(300, 200);
		JPanel panelWarning = new JPanel(new GridBagLayout());
		
        warning.setLocationRelativeTo(null);
        GridBagConstraints labelGBCWarning = new GridBagConstraints();
        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
		
		JLabel warningStr = new JLabel(printText);
		JButton warningOkButton = new JButton("Ok");
		
		panelWarning.add(warningStr, labelGBCWarning);
		panelWarning.add(warningOkButton);
		
		warning.add(panelWarning, BorderLayout.NORTH);
		
		warning.setVisible(true);
		
		warningOkButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				warning.dispatchEvent(new WindowEvent(warning, WindowEvent.WINDOW_CLOSING));
			}	
		});
	}
	
}