package ClubManagement;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateClubGUI extends JFrame {
	
	private User u1;
	private Application app1;
	
	public CreateClubGUI(User user, Application app) {
		super("Add a Club!");
		this.setSize(500, 300);
		
		u1 = user;
		app1 = app;
		
		this.setLayout(new BorderLayout());
		setVisible(true);
		buildGUI();
		
	}

	private void buildGUI() {
		//JFrame frame = new JFrame("Add a Club!");
		this.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel newNameLabel = new JLabel("Club Name: ");
		JTextField newName = new JTextField(10);
		
		JLabel newDescriptionLabel = new JLabel("Club Description ");
		JTextField newDescription = new JTextField(10);
		
		// les buttons
		JButton add = new JButton("Add Club!");
		JButton cancelButton = new JButton("Cancel");
		
        this.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(newNameLabel, labelGBC);
        panel.add(newName, fieldGBC);
        
        panel.add(newDescriptionLabel, labelGBC);
        panel.add(newDescription, fieldGBC);
        
        panel.add(add);
		panel.add(cancelButton);
		
		this.add(panel, BorderLayout.NORTH);
		
		this.setVisible(true);
		
		// cancel button closes window
		cancelButton.addActionListener(e -> {
				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}	
		);
		
		// cancel button closes window
		add.addActionListener(e -> {
			
			String aName = newName.getText();
			String aDescription = newDescription.getText();

			if(app1.doesClubExist(aName) == true) {
				buildWarningGUI("Error " + aName +
						" already exists.", "Error");
				return;
			}
			else {
				Club club = new Club();
				club.setName(aName);
				club.setDescription(aDescription);
				u1.addClub(club);
				club.setPresident(u1);
				app1.addClub(club);
				dispose();
			}
			
			}	
		);
		
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