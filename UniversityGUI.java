package org.university.software;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import org.university.hardware.Department;
import org.university.people.Student;

import javax.swing.*;

/* Demo by Lahiru Ariyananda and Peter Hall
   Note :  this is very simple program  used as a  demo on  Serilizing and GUIs. 
   It does not test for faults or errors (  which needs to be implemented) 
 */



public class UniversityGUI extends JFrame 
{ 
	private University  univ1;
	private JMenuBar menuBar;		//the horizontal container
	private JMenu adminMenu;		//JMenu objects are added to JMenuBar objects as the "tabs"
	private JMenu fileMenu;
	private JMenu studentMenu;
	//private ArrayList<University> empList;

	// File submenus
	
	private JMenuItem fileSave;
    private JMenuItem fileLoad;
	private JMenuItem fileExit;
	
	// Admin 
	
	private JMenuItem adminPrintAll; 		//JMenuItem objects are added to JMenu objects as the drop down selections. 

	// Student
	
	private JMenuItem addCourse;
	private JMenuItem dropCourse;
	private JMenuItem printSchedule;
	
	// Jframe
	
	private JPanel container;
    private JScrollPane scrollPane;
	
	public UniversityGUI(String windowTitle, University aUniv1) 
	{   
		super(windowTitle);

   		//univ1 = new University() ;
		univ1 = aUniv1;

		setSize(300, 100);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Welcome to Human Resource System" +
				"<BR>Choose an action from the above menus.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	
	public void buildGUI() 
	{
		menuBar = new JMenuBar();
		
		adminMenu = new JMenu("Administrator");

		
		adminPrintAll = new JMenuItem("Print Employee Info");

		//JMenuItem's, via AbstractButton, have a method addActionListener(ActionListener)
		adminPrintAll.addActionListener(new MenuListener());		//The innerclass is implementing ActionListener, so it can take action when the JMenuItem is clicked.
	    
		adminMenu.add(adminPrintAll);
		
		// Student Menu
		studentMenu = new JMenu("Student");
		
		addCourse = new JMenuItem("Add Course");
		dropCourse = new JMenuItem("Drop Course");
		printSchedule = new JMenuItem("Print Schedule");
		
	    addCourse.addActionListener(new MenuListener());
	    dropCourse.addActionListener(new MenuListener());
	    printSchedule.addActionListener(new MenuListener());
	    
	    studentMenu.add(addCourse);
	    studentMenu.add(dropCourse);
	    studentMenu.add(printSchedule);
		
		// file JMenu items
	    fileMenu = new JMenu("File");
	    
		fileSave = new JMenuItem ("Save" );
		fileLoad = new JMenuItem("Load");
		fileExit = new JMenuItem("Exit");
				
		fileSave.addActionListener(new MenuListener());		//JMenuItem's, via AbstractButton, have a method addActionListener(ActionListener)
		fileLoad.addActionListener(new MenuListener());		//The innerclass is implementing ActionListener, so it can take action when the JMenuItem is clicked.
	    fileExit.addActionListener(new MenuListener());
		
	    fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
	    
		// add items in order
	    menuBar.add(fileMenu);
	    menuBar.add(studentMenu);
	    menuBar.add(adminMenu);
	
		setJMenuBar(menuBar);
	}
	
	
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(adminPrintAll))
			{
				JFrame frame = new JFrame("University info");

				// panel.add(...);
				String str = univ1.printToScroller();
				JTextArea textSpace = new JTextArea(50, 150);
				textSpace.setText(str);
				
				scrollPane = new JScrollPane(textSpace);
				
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
				//frame.pack();
				frame.setVisible(true);
				
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				handleAdminPrint();
				
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					}	
				});
			}
			else if(source.equals(fileSave))
			{
				handleFileSaveData();
			}
			else if(source.equals(fileLoad))
			{
				handleFileLoadData();
			}
			else if(source.equals(fileExit)) {
				handleFileExit();
			}
			else if(source.equals(addCourse)) {
				handleAddCourse();
			}
			else if(source.equals(dropCourse)) {
				handleDropCourse();
			}
			else if(source.equals(printSchedule)) {
				handlePrintSchedule();
			}
		}
		
		private void handleAdminPrint() 
		{
			if( univ1!=null)
			{
				univ1.printAll();
			}
			else
			{
				JOptionPane.showMessageDialog(null, 
						"No University", 
						"Error", 
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		public void handleFileSaveData() {
			if( univ1!=null)
			{
				University.saveData(univ1);
			}
			else
			{
				JOptionPane.showMessageDialog(null, 
						"No Employee", 
						"Error", 
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		public void handleFileLoadData() {
			if( univ1!=null)
			{
				univ1 = University.loadData();
			}
			else
			{
				JOptionPane.showMessageDialog(null, 
						"No Employee", 
						"Error", 
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		public void handleFileExit() {
			System.exit(0);
		}
		public void handleAddCourse() {
			JFrame frame = new JFrame("Add Course");
			frame.setSize(400, 200);
			JPanel panel = new JPanel(new GridBagLayout());
			
			JLabel stuNameLabel = new JLabel("Student Name: ");
			JTextField stuNameText = new JTextField(10);
			
			JLabel stuDeptLabel = new JLabel("Department: ");
			JTextField stuDeptText = new JTextField(10);
			
			JLabel stuCourseLabel = new JLabel("Course #: ");
			JTextField stuCourseText = new JTextField(10);
			
			// les buttons
			JButton okButton = new JButton("Ok");
			JButton cancelButton = new JButton("Cancel");
			
	        frame.setLocationRelativeTo(null);
	        GridBagConstraints labelGBC = new GridBagConstraints();
	        labelGBC.insets = new Insets(3, 3, 3, 3);
	        GridBagConstraints fieldGBC = new GridBagConstraints();
	        fieldGBC.insets = new Insets(3, 3, 3, 3);
	        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
	        
	        panel.add(stuNameLabel, labelGBC);
	        panel.add(stuNameText, fieldGBC);
	        panel.add(stuDeptLabel, labelGBC);
	        panel.add(stuDeptText, fieldGBC);
	        panel.add(stuCourseLabel, labelGBC);
	        panel.add(stuCourseText, fieldGBC);
	        
	        panel.add(okButton);
			panel.add(cancelButton);
			
			frame.add(panel, BorderLayout.NORTH);
			
			frame.setVisible(true);
			
			okButton.addActionListener(new ActionListener()
			{	
				public void actionPerformed(ActionEvent e) {
					
					String studentName = stuNameText.getText();
					String departmentName = stuDeptText.getText();
					String courseNum = stuCourseText.getText();
					
					Student stu = univ1.searchStudent(studentName);
					Department dept = univ1.searchDepartment(departmentName);
					if(stu.getName().equals("empty")) {
						//int value = JOptionPane.showConfirmDialog(null, "Student " + studentName +
								//" is not a student","Error adding student.course", JOptionPane.WARNING_MESSAGE);
						
						JFrame warning = new JFrame("Error adding student to course");
						warning.setSize(300, 200);
						JPanel panelWarning = new JPanel(new GridBagLayout());
						
				        warning.setLocationRelativeTo(null);
				        GridBagConstraints labelGBCWarning = new GridBagConstraints();
				        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
				        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
						
						JLabel warningStr = new JLabel("Student " + "\"" + studentName + "\"" + " doesn't exist");
						JButton warningOkButton = new JButton("Ok");
						
						panelWarning.add(warningStr, labelGBCWarning);
						panelWarning.add(warningOkButton);
						
						warning.add(panelWarning, BorderLayout.NORTH);
						
						warning.setVisible(true);
						
						warningOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}	
						});
						
					}
					else if(dept.getDepartmentName().equals("empty")) {
						JFrame warning = new JFrame("Error adding student to course");
						warning.setSize(300, 200);
						JPanel panelWarning = new JPanel(new GridBagLayout());
						
				        warning.setLocationRelativeTo(null);
				        GridBagConstraints labelGBCWarning = new GridBagConstraints();
				        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
				        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
						
						JLabel warningStr = new JLabel("Department " + "\"" + departmentName + "\"" + " doesn't exist");
						JButton warningOkButton = new JButton("Ok");
						
						panelWarning.add(warningStr, labelGBCWarning);
						panelWarning.add(warningOkButton);
						
						warning.add(panelWarning, BorderLayout.NORTH);
						
						warning.setVisible(true);
						
						warningOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}	
						});
						
					}
					else {
						Course c1 = dept.searchCourses(courseNum);
						if(c1.getName().equals("empty")) {
							JFrame warning = new JFrame("Error adding student to course");
							warning.setSize(300, 200);
							JPanel panelWarning = new JPanel(new GridBagLayout());
							
					        warning.setLocationRelativeTo(null);
					        GridBagConstraints labelGBCWarning = new GridBagConstraints();
					        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
					        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
							
							JLabel warningStr = new JLabel("Course " + "\"" + departmentName + courseNum + "\"" + " doesn't exist");
							JButton warningOkButton = new JButton("Ok");
							
							panelWarning.add(warningStr, labelGBCWarning);
							panelWarning.add(warningOkButton);
							
							warning.add(panelWarning, BorderLayout.NORTH);
							
							warning.setVisible(true);
							
							warningOkButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) {
									warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
								}	
							});
						}
						if(!(stu.detectCourseConflict(c1).equals(""))) {
							JFrame warning = new JFrame("Error adding student to course");
							warning.setSize(900, 100);
							JPanel panelWarning = new JPanel(new GridBagLayout());
							
					        warning.setLocationRelativeTo(null);
					        GridBagConstraints labelGBCWarning = new GridBagConstraints();
					        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
					        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
							String str = stu.detectCourseConflict(c1);
							JLabel warningStr = new JLabel(str);
							JButton warningOkButton = new JButton("Ok");
							
							panelWarning.add(warningStr, labelGBCWarning);
							panelWarning.add(warningOkButton);
							
							warning.add(panelWarning, BorderLayout.NORTH);
							
							warning.setVisible(true);
							
							warningOkButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) {
									warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
								}	
							});
							
						}
						else {
							stu.addCourse(c1);	
						}
					}				
					
				}
			});
			cancelButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}	
			});
			
		}
		
		public void handleDropCourse() {
			JFrame frame = new JFrame("Drop Course");
			frame.setSize(400, 200);
			JPanel panel = new JPanel(new GridBagLayout());
			
			JLabel stuNameLabel = new JLabel("Student Name: ");
			JTextField stuNameText = new JTextField(10);
			
			JLabel stuDeptLabel = new JLabel("Department: ");
			JTextField stuDeptText = new JTextField(10);
			
			JLabel stuCourseLabel = new JLabel("Course #: ");
			JTextField stuCourseText = new JTextField(10);
			
			// les buttons
			JButton okButton = new JButton("Ok");
			JButton cancelButton = new JButton("Cancel");
			
	        frame.setLocationRelativeTo(null);
	        GridBagConstraints labelGBC = new GridBagConstraints();
	        labelGBC.insets = new Insets(3, 3, 3, 3);
	        GridBagConstraints fieldGBC = new GridBagConstraints();
	        fieldGBC.insets = new Insets(3, 3, 3, 3);
	        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
	        
	        panel.add(stuNameLabel, labelGBC);
	        panel.add(stuNameText, fieldGBC);
	        panel.add(stuDeptLabel, labelGBC);
	        panel.add(stuDeptText, fieldGBC);
	        panel.add(stuCourseLabel, labelGBC);
	        panel.add(stuCourseText, fieldGBC);
	        
	        panel.add(okButton);
			panel.add(cancelButton);
			
			frame.add(panel, BorderLayout.NORTH);
			
			frame.setVisible(true);
			
			okButton.addActionListener(new ActionListener()
			{	
				public void actionPerformed(ActionEvent e) {
					
					String studentName = stuNameText.getText();
					String departmentName = stuDeptText.getText();
					String courseNum = stuCourseText.getText();
					
					Student stu = univ1.searchStudent(studentName);
					Department dept = univ1.searchDepartment(departmentName);
					if(stu.getName().equals("empty")) {
						//int value = JOptionPane.showConfirmDialog(null, "Student " + studentName +
								//" is not a student","Error adding student.course", JOptionPane.WARNING_MESSAGE);
						
						JFrame warning = new JFrame("Error dropping student from course");
						warning.setSize(300, 200);
						JPanel panelWarning = new JPanel(new GridBagLayout());
						
				        warning.setLocationRelativeTo(null);
				        GridBagConstraints labelGBCWarning = new GridBagConstraints();
				        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
				        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
						
						JLabel warningStr = new JLabel("Student " + "\"" + studentName + "\"" + " doesn't exist");
						JButton warningOkButton = new JButton("Ok");
						
						panelWarning.add(warningStr, labelGBCWarning);
						panelWarning.add(warningOkButton);
						
						warning.add(panelWarning, BorderLayout.NORTH);
						
						warning.setVisible(true);
						
						warningOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}	
						});
						
					}
					else if(dept.getDepartmentName().equals("empty")) {
						JFrame warning = new JFrame("Error dropping student from course");
						warning.setSize(300, 200);
						JPanel panelWarning = new JPanel(new GridBagLayout());
						
				        warning.setLocationRelativeTo(null);
				        GridBagConstraints labelGBCWarning = new GridBagConstraints();
				        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
				        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
						
						JLabel warningStr = new JLabel("Department " + "\"" + departmentName + "\"" + " doesn't exist");
						JButton warningOkButton = new JButton("Ok");
						
						panelWarning.add(warningStr, labelGBCWarning);
						panelWarning.add(warningOkButton);
						
						warning.add(panelWarning, BorderLayout.NORTH);
						
						warning.setVisible(true);
						
						warningOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}	
						});
						
					}
					else {
						Course c1 = dept.searchCourses(courseNum);
						if(c1.getName().equals("empty")) {
							JFrame warning = new JFrame("Error dropping student from course");
							warning.setSize(300, 200);
							JPanel panelWarning = new JPanel(new GridBagLayout());
							
					        warning.setLocationRelativeTo(null);
					        GridBagConstraints labelGBCWarning = new GridBagConstraints();
					        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
					        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
							
							JLabel warningStr = new JLabel("Course " + "\"" + departmentName + courseNum + "\"" + " doesn't exist");
							JButton warningOkButton = new JButton("Ok");
							
							panelWarning.add(warningStr, labelGBCWarning);
							panelWarning.add(warningOkButton);
							
							warning.add(panelWarning, BorderLayout.NORTH);
							
							warning.setVisible(true);
							
							warningOkButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) {
									warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
								}	
							});
						}
						if(stu.detectCourse(c1) == false) {
							//System.out.println("here");
							JFrame warning = new JFrame("Error dropping student from course");
							warning.setSize(900, 100);
							JPanel panelWarning = new JPanel(new GridBagLayout());
							
					        warning.setLocationRelativeTo(null);
					        GridBagConstraints labelGBCWarning = new GridBagConstraints();
					        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
					        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
							
							JLabel warningStr = new JLabel(departmentName + courseNum + " does not exist in " + studentName
									+ "'s schedule.");
							JButton warningOkButton = new JButton("Ok");
							
							panelWarning.add(warningStr, labelGBCWarning);
							panelWarning.add(warningOkButton);
							
							warning.add(panelWarning, BorderLayout.NORTH);
							
							warning.setVisible(true);
							
							warningOkButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) {
									warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
								}	
							});
							
						}
						else {
							stu.dropCourse(c1);	
						}
					}				
					
				}
			});
			cancelButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}	
			});
			
		}
		public void handlePrintSchedule() {
			JFrame frame = new JFrame("Print Student Schedule");
			frame.setSize(400, 200);
			JPanel panel = new JPanel(new GridBagLayout());
			
			JLabel stuNameLabel = new JLabel("Student Name: ");
			JTextField stuNameText = new JTextField(10);
			
			// les buttons
			JButton okButton = new JButton("Ok");
			JButton cancelButton = new JButton("Cancel");
			
	        frame.setLocationRelativeTo(null);
	        GridBagConstraints labelGBC = new GridBagConstraints();
	        labelGBC.insets = new Insets(3, 3, 3, 3);
	        GridBagConstraints fieldGBC = new GridBagConstraints();
	        fieldGBC.insets = new Insets(3, 3, 3, 3);
	        fieldGBC.gridwidth = GridBagConstraints.REMAINDER;
	        
	        panel.add(stuNameLabel, labelGBC);
	        panel.add(stuNameText, fieldGBC);
	        
	        panel.add(okButton);
			panel.add(cancelButton);
			
			frame.add(panel, BorderLayout.NORTH);
			
			frame.setVisible(true);
			
			okButton.addActionListener(new ActionListener()
			{	
				public void actionPerformed(ActionEvent e) {
					
					String studentName = stuNameText.getText();
					
					Student stu = univ1.searchStudent(studentName);
					if(stu.getName().equals("empty")) {
						//int value = JOptionPane.showConfirmDialog(null, "Student " + studentName +
								//" is not a student","Error adding student.course", JOptionPane.WARNING_MESSAGE);
						
						JFrame warning = new JFrame("Error printing schedule");
						warning.setSize(300, 200);
						JPanel panelWarning = new JPanel(new GridBagLayout());
						
				        warning.setLocationRelativeTo(null);
				        GridBagConstraints labelGBCWarning = new GridBagConstraints();
				        labelGBCWarning.insets = new Insets(3, 3, 3, 3);
				        labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
						
						JLabel warningStr = new JLabel("Student " + "\"" + studentName + "\"" + " is not a student");
						JButton warningOkButton = new JButton("Ok");
						
						panelWarning.add(warningStr, labelGBCWarning);
						panelWarning.add(warningOkButton);
						
						warning.add(panelWarning, BorderLayout.NORTH);
						
						warning.setVisible(true);
						
						warningOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								warning.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}	
						});
						
					}
					else {
						//int value = JOptionPane.showConfirmDialog(null, "Student " + studentName +
						//" is not a student","Error adding student.course", JOptionPane.WARNING_MESSAGE);
				
						JFrame printStuSched = new JFrame("Student " + studentName + "'s Schedule");
						printStuSched.setSize(500, 500);
						JPanel panelWarning = new JPanel(new GridBagLayout());
				
						printStuSched.setLocationRelativeTo(null);
						GridBagConstraints labelGBCWarning = new GridBagConstraints();
						labelGBCWarning.insets = new Insets(3, 3, 3, 3);
						labelGBCWarning.gridwidth = GridBagConstraints.REMAINDER;
				
						String str = stu.stringScheduleStudentMenu();
						
						JLabel warningStr = new JLabel(str);
						JButton warningOkButton = new JButton("Ok");
				
						panelWarning.add(warningStr, labelGBCWarning);
						panelWarning.add(warningOkButton);
				
						printStuSched.add(panelWarning, BorderLayout.NORTH);
				
						printStuSched.setVisible(true);
				
						warningOkButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								printStuSched.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}	
						});		
					}				
					
				}
			});
			cancelButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}	
			});
			
		}

	}
	
}


