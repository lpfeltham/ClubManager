package ClubManagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClubPageGUI extends JFrame {
	
	private User u1;
	private Event e1;
	private Position pos1;
	private Club c1;
	private Application app1;
	
	public ClubPageGUI(Club club, User user, Application app) {
		
		super(club.getName());
		this.setSize(500, 300);
		
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
		DefaultListModel<String> eventDetails = new DefaultListModel<>(); 
		DefaultListModel<String> optionsList = new DefaultListModel<>(); 
		
		setLocationRelativeTo(null);
		
		for(int i = 0; i < c1.getEvents().size(); i++) {
			eventList.addElement(c1.getEvents().get(i).getName());
			
			eventDetails.addElement("<HTML><B>" + c1.getEvents().get(i).getName() + 
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
		JList<String> eventInfo = new JList<>(eventDetails);
		
		this.add(edit, BorderLayout.SOUTH);
		this.add(optionString, BorderLayout.WEST);
		this.add(eventString, BorderLayout.CENTER);
		this.add(placedLabel, BorderLayout.NORTH);
		this.add(eventInfo, BorderLayout.EAST);
		
        pos1 = u1.findMember(c1);
        
		// sign up action event listener
		edit.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String selectedFunction = optionString.getSelectedValue();
				String selectedEvent = eventString.getSelectedValue();
				//Event e1 = new Event();
				System.out.println(selectedEvent);
				for(int i = 0; i < c1.getEvents().size(); i++) {
					if(c1.getEvents().get(i).getName().equals(selectedEvent)) {
						e1 = c1.getEvents().get(i);
						System.out.println(e1.getName());
					}
				}
				
				if(selectedFunction.equals("Edit Event Schedule")) {
					// Generate edit event schedule
					buildEditEventSchedule();
					
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
		//JPanel panel = new JPanel(new GridBagLayout());
				JLabel placedLabel = new JLabel("  Welcome to " + club.getName());
				JLabel placedDescription = new JLabel("  " + club.getDescription());
				JButton edit = new JButton("Edit Event");
				JButton newEvent = new JButton("Add an Event");
				
				
				//this.add(placedLabel);
				//this.add(placedDescription);
				
				DefaultListModel<String> eventList = new DefaultListModel<>(); 
				DefaultListModel<String> eventDetails = new DefaultListModel<>(); 
				DefaultListModel<String> optionsList = new DefaultListModel<>(); 
				
				setLocationRelativeTo(null);
				
				for(int i = 0; i < c1.getEvents().size(); i++) {
					eventList.addElement(c1.getEvents().get(i).getName());
					
					eventDetails.addElement("<HTML><B>" + c1.getEvents().get(i).getName() + 
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
				optionsList.addElement("Remove Event");
				optionsList.addElement("Add Event");
				optionsList.addElement("Add Officer");
				optionsList.addElement("Change President");
				optionsList.addElement("Print All Users");
				
				JList<String> optionString = new JList<>(optionsList);
				JList<String> eventString = new JList<>(eventList);
				JList<String> eventInfo = new JList<>(eventDetails);
				
				this.add(edit, BorderLayout.SOUTH);
				this.add(optionString, BorderLayout.WEST);
				this.add(eventString, BorderLayout.CENTER);
				this.add(placedLabel, BorderLayout.NORTH);
				this.add(eventInfo, BorderLayout.EAST);
				
		        pos1 = u1.findMember(c1);
		        
				// sign up action event listener
				edit.addActionListener(new ActionListener() {	
					public void actionPerformed(ActionEvent e) {
						String selectedFunction = optionString.getSelectedValue();
						String selectedEvent = eventString.getSelectedValue();
						//Event e1 = new Event();
						System.out.println(selectedEvent);
						for(int i = 0; i < c1.getEvents().size(); i++) {
							if(c1.getEvents().get(i).getName().equals(selectedEvent)) {
								e1 = c1.getEvents().get(i);
								System.out.println(e1.getName());
							}
						}
						
						if(selectedFunction.equals("Edit Event Schedule")) {
							// Generate edit event schedule
							buildEditEventSchedule();
							
						}
						else if(selectedFunction.equals("Edit Event Place")) {
							buildEditEventPlace();
						}
						else if(selectedFunction.equals("Remove Event")) {
							// remove event from event list in club
							c1.removeEvent(e1.getName());
							// remove event from schedule list in place
							Place p1 = e1.getPlace();
							p1.cancelSchedule(e1.getSchedule());
						}
						else if(selectedFunction.equals("Add Event")) {
							buildNewEventGUI();
						}
						else if(selectedFunction.equals("Change President")) {
							
						}
						else if(selectedFunction.equals("Add Officer")) {
							buildNewAddOfficer();
						}
						else if(selectedFunction.equals("Print All Users")) {
							buildNewPrintPane();
						}
						else {
							// Generate edit event name
							 buildEditEventName();	
						}
					}
				});
				newEvent.addActionListener(new ActionListener() {	
					public void actionPerformed(ActionEvent e) {
						// Build new event GUI
						buildNewEventGUI();
					}
				});
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
		cancelButton.addActionListener(e -> {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		);
		
		// cancel button closes window
		edit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String newTxt = newNameField.getText();
				if(app1.doesPlaceExist(newTxt) == false) {
					buildWarningGUI("Error " + newNameField.getText() +
							" does not exist.", "Error");
				}
				else {
					Place p1 = app1.getPlace(newTxt);
					
					if(p1.detectScheduleConflict(e1.getSchedule()) == true) {
						buildWarningGUI("Error schedule conflict", "Error");
					}
					else {
						p1.cancelSchedule(e1.getSchedule());
						e1.setPlace(p1);
						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					}
				}
			}	
		});
		
	}
	
	private void buildEditEventSchedule() {
		JFrame frame = new JFrame("Edit Event Schedule");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel newStartHourLabel = new JLabel("New Start Hour for " + e1.getName() + ":");
		JTextField newStartHour = new JTextField(10);
		
		JLabel newEndHourLabel = new JLabel("New End Hour for " + e1.getName() + ":");
		JTextField newEndHour = new JTextField(10);
		
		JLabel newDateLabel = new JLabel("New date Hour for " + e1.getName() + ":");
		JTextField newDate = new JTextField(10);
		
		// les buttons
		JButton edit = new JButton("Edit");
		JButton cancelButton = new JButton("Cancel");
		
        frame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(newStartHourLabel, labelGBC);
        panel.add(newStartHour, fieldGBC);
        panel.add(newEndHourLabel, labelGBC);
        panel.add(newEndHour, fieldGBC);
        panel.add(newDateLabel, labelGBC);
        panel.add(newDate, fieldGBC);
        
        panel.add(edit);
		panel.add(cancelButton);
		
		frame.add(panel, BorderLayout.NORTH);
		
		frame.setVisible(true);
		
		// cancel button closes window
		cancelButton.addActionListener(e -> {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		);
		
		// cancel button closes window
		edit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				double newStart = Double.parseDouble(newStartHour.getText());
				double newEnd = Double.parseDouble(newEndHour.getText());
				String date = newDate.getText();
				
				Schedule s1 = new Schedule();
				s1.setStartHour(newStart);
				s1.setEndHour(newEnd);
				s1.setDate(date);
				
				if(e1.getPlace().detectScheduleConflict(s1)) {
					buildWarningGUI("Error schedule conflict", "Error");
				}
				else {
					e1.getPlace().cancelSchedule(e1.getSchedule());
					e1.setSchedule(s1);
					e1.getPlace().addSchedule(s1);
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}	
		});
	}
	
	private void buildNewEventGUI() {
		JFrame frame = new JFrame("Add an event!");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel newNameLabel = new JLabel("Event Name: ");
		JTextField newName = new JTextField(10);
		
		JLabel newPlaceLabel = new JLabel("Event Place: ");
		JTextField newPlace = new JTextField(10);
		
		JLabel newStartLabel = new JLabel("Event Start Hour: ");
		JTextField newStartHour = new JTextField(10);
		
		JLabel newEndLabel = new JLabel("Event End Hour: ");
		JTextField newEndHour = new JTextField(10);
		
		JLabel newDateLabel = new JLabel("Event Date: ");
		JTextField newDate = new JTextField(10);
		
		// les buttons
		JButton edit = new JButton("Add Event!");
		JButton cancelButton = new JButton("Cancel");
		
        frame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(newNameLabel, labelGBC);
        panel.add(newName, fieldGBC);
        
        panel.add(newPlaceLabel, labelGBC);
        panel.add(newPlace, fieldGBC);
        
        panel.add(newStartLabel, labelGBC);
        panel.add(newStartHour, fieldGBC);
        
        panel.add(newEndLabel, labelGBC);
        panel.add(newEndHour, fieldGBC);
        
        panel.add(newDateLabel, labelGBC);
        panel.add(newDate, fieldGBC);
        
        panel.add(edit);
		panel.add(cancelButton);
		
		frame.add(panel, BorderLayout.NORTH);
		
		frame.setVisible(true);
		
		// cancel button closes window
		cancelButton.addActionListener(e -> {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		);
		
		// cancel button closes window
		edit.addActionListener(e -> {
			double newStart = Double.parseDouble(newStartHour.getText());
			double newEnd = Double.parseDouble(newEndHour.getText());
			String date = newDate.getText();
			
			Schedule s1 = new Schedule();
			s1.setStartHour(newStart);
			s1.setEndHour(newEnd);
			s1.setDate(date);
			
			String aName = newName.getText();
			String aPlace = newPlace.getText();
			
			Event e6 = new Event();
			e6.setName(aName);
			e6.setSchedule(s1);
			
			if(app1.doesPlaceExist(aPlace) == false) {
				buildWarningGUI("Error " + aPlace +
						" does not exist.", "Error");
			}
			else {
				Place p1 = app1.getPlace(aPlace);
				
				if(p1.detectScheduleConflict(s1) == true) {
					buildWarningGUI("Error schedule conflict", "Error");
				}
				else {
					//p1.cancelSchedule(e1.getSchedule());
					e6.setPlace(p1);
					c1.addEvent(e6);
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
			
			}	
		);
	}
	
	private void buildNewAddOfficer() {
		JFrame frame = new JFrame("Add New Officer");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel newNameLabel = new JLabel("Member Name: ");
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
		cancelButton.addActionListener(e -> {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		);
		
		// cancel button closes window
		edit.addActionListener(e -> {
				String newOfficerName = newNameField.getText();
				User newOfficer = app1.getUser(newOfficerName);
				if(newOfficer == null) {
					buildWarningGUI("Error, user doesn't exist", "Error");
				}
				else if(c1.searchMember(newOfficerName) == null) {
					buildWarningGUI("Error, user not in club. Maybe you should invite them?", "Error");
				}
				else if(newOfficer.findPosition(c1).equals("Member")) {
					newOfficer.updateUserPosition("Officer", c1);
				}
				
				else {
					buildWarningGUI("Error, user already officer or president", "Error");
				}
				
				
			}	
		);
	}
	
	private void buildNewPrintPane() {
		JFrame frame = new JFrame("User Info");

		// panel.add(...);
		//String str = c1.printUsersScroller();
		String str = "hello world";
		JTextArea textSpace = new JTextArea(50, 150);
		textSpace.setText(str);
		
		JScrollPane scrollPane = new JScrollPane(textSpace);
		
		frame.getContentPane().setLayout(new BorderLayout());
		// only a configuration to the jScrollPane...
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.setSize(500, 500);
		
		
		JButton okButton = new JButton("Ok");
		scrollPane.add(okButton);
		okButton.setVisible(true);
		scrollPane.setVisible(true);
		
		JPanel panel = new JPanel(); //Flow layout by default
		//If you want to anchor the buttons to the right you might try
		panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		panel.add(okButton);
		panel.setVisible(true);
		
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		// Then, add the jScrollPane to your frame
		frame.add(scrollPane);
		frame.setVisible(true);
		
		//handleAdminPrint();
		
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}	
		});
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
