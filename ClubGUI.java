package ClubManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ClubGUI extends JFrame {
	private Application app1;
	private User u1;
	
	private JButton Login;
	private JButton SignUp;

	
	public ClubGUI(String windowTitle, Application AnApp1) 
	{   
		super(windowTitle);

		app1 = AnApp1;
		u1 = null;

		this.setSize(300, 300);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		buildGUI();	
		setVisible(true);
		
		
		try {
			this.setIconImage(ImageIO.read(new File("C:\\Users\\zkare\\Desktop\\AZ.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void buildGUI() {
		GridLayout Layout = new GridLayout(0,1);
		
		JPanel panel = new JPanel(Layout); 
		
		
		JLabel placedLabel = new JLabel("<HTML><center>Welcome to the Club Manager!!" + 
								"<BR>Please login or create a new user<BR></center></HTML>");
        
		setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
		
		Login = new JButton("Login");
		SignUp = new JButton("Sign Up!");
		Login.setBackground(Color.cyan);
		SignUp.setBackground(Color.green);
		
		panel.add(placedLabel, labelGBC);
		

		panel.add(Login, fieldGBC);
		panel.add(SignUp, fieldGBC);
		
		
	
		this.add(panel, BorderLayout.NORTH);
		
		// login action event listener
		Login.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(u1 == null) {
					buildLoginGUI();
					//();
				}
				else {
					buildWarningGUI("Already logged in " + u1.getName() + ".", "Event Update");
				}
			}
		});
		
		// sign up action event listener
		SignUp.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(u1 == null) {
					buildSignUpGUI();
				}
				else {
					buildWarningGUI("Already logged in as " + u1.getName() + ".", "Event Update");
				}
				
			}
		});
	}
	
	
	
	private void buildLoginGUI() {
		boolean returnVar = false;
		JFrame frame = new JFrame("Login");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel stuNameLabel = new JLabel("User Name: ");
		JTextField userNameText = new JTextField(10);
		
		 JLabel stuDeptLabel = new JLabel("Password: ");
		 JPasswordField passwordText = new JPasswordField(10);
		
		// les buttons
		JButton okButton = new JButton("Login");
		JButton cancelButton = new JButton("Cancel");
		
        frame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(stuNameLabel, labelGBC);
        panel.add(userNameText, fieldGBC);
        panel.add(stuDeptLabel, labelGBC);
        panel.add(passwordText, fieldGBC);
        
        okButton.setBackground(Color.green);
        cancelButton.setBackground(Color.red);
        
        panel.add(okButton);
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
		
		// ok button checks if user and password are correct
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String userName = userNameText.getText();
				String password = passwordText.getText();
				// check user and password
				u1 = app1.checkPassword(userName, password);
				
				if(u1 == null) {
					buildWarningGUI("User or password incorrect.", "Error");
					
				}
				else {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					//buildWarningGUI("logged in.", "Event Update");
					
					//returnVar = true;
					//LoginGUI logged_in = new LoginGUI("Welcome " + u1.getName(), app1, u1);
					InitialGUI startGUI = new InitialGUI("Welcome " + u1.getName(), app1, u1);
					
				}
				
			}	
		});
	}
	
	private void buildSignUpGUI() {
		JFrame frame = new JFrame("Login");
		frame.setSize(400, 200);
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel stuNameLabel = new JLabel("User Name: ");
		JTextField userNameText = new JTextField(10);
		
		JLabel nameLabel = new JLabel("Name (displayed on interface)");
		JTextField nameText = new JTextField(10);
		
		 JLabel stuDeptLabel = new JLabel("Password: ");
		 JPasswordField passwordText = new JPasswordField(10);
		
		// les buttons
		JButton okButton = new JButton("Sign Up!");
		JButton cancelButton = new JButton("Cancel");
		
        frame.setLocationRelativeTo(null);
        GridBagConstraints labelGBC = new GridBagConstraints();
        labelGBC.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints fieldGBC = new GridBagConstraints();
        fieldGBC.insets = new Insets(3, 3, 3, 3);
        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        panel.add(stuNameLabel, labelGBC);
        panel.add(userNameText, fieldGBC);
        panel.add(nameLabel, labelGBC);
        panel.add(nameText, fieldGBC);
        panel.add(stuDeptLabel, labelGBC);
        panel.add(passwordText, fieldGBC);
        
        panel.add(okButton);
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
		
		// ok button checks if user and password are correct
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String userName = userNameText.getText();
				String password = passwordText.getText();
				String name = nameText.getText();
				
				 // check user exists
				if(app1.detectNewUserConflict(userName)) {
					buildWarningGUI("User already exists", "Error");
				}
				else {
					User newUser = new User();
					newUser.setUsername(userName);
					newUser.setPassword(password);
					newUser.setName(name);
					app1.addUser(newUser);
					
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					
					buildWarningGUI("You have been added to the Users.", "Event Update");
				}
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
