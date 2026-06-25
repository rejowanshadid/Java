package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class FacultySectionRegistrationFrame extends JFrame implements ActionListener
{
	private JLabel registrationIdLabel, semesterIdLabel, studentIdLabel,dateLabel;
	private JTextField registrationIdTF, semesterIdTF, studentIdTF, dateTF;
	private JButton startBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	public FacultySectionRegistrationFrame(User u)
	{
		super("Faculty Do Registration Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.registrationIdLabel=new JLabel("Registration Id:");
		this.registrationIdLabel.setBounds(50,50,150,30);
		this.panel.add(registrationIdLabel);
		
		this.registrationIdTF=new JTextField();
		this.registrationIdTF.setBounds(220,50,100,30);
		this.panel.add(registrationIdTF);
		
		this.semesterIdLabel=new JLabel("Semester Id:");
		this.semesterIdLabel.setBounds(50,100,150,30);
		this.panel.add(semesterIdLabel);
		
		this.semesterIdTF=new JTextField();
		this.semesterIdTF.setBounds(220,100,100,30);
		this.panel.add(semesterIdTF);
		
		this.studentIdLabel=new JLabel("Student Id:");
		this.studentIdLabel.setBounds(50,150,150,30);
		this.panel.add(studentIdLabel);
		
		this.studentIdTF=new JTextField();
		this.studentIdTF.setBounds(220,150,150,30);
		this.panel.add(studentIdTF);
		
		this.dateLabel=new JLabel("Date:");
		this.dateLabel.setBounds(50,200,60,30);
		this.panel.add(dateLabel);
		
		this.dateTF=new JTextField();
		this.dateTF.setBounds(220,200,100,30);
		this.panel.add(dateTF);
		
		
		this.startBtn=new JButton("Start Registration");
		this.startBtn.setBounds(50,250,200,30);
		this.startBtn.addActionListener(this);
		this.panel.add(startBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(290,250,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(startBtn.getText()))
		{
			//validating every field has data or not
			if((!registrationIdTF.getText().isEmpty()) && (!semesterIdTF.getText().isEmpty()) && (!studentIdTF.getText().isEmpty()) && (!dateTF.getText().isEmpty()))
			{
				//to check whether the registration id is unique or not.
				RegistrationRepo rrp=new RegistrationRepo();
				Registration r=rrp.searchRegistrationByRegistrationId(registrationIdTF.getText());
				//if the registration id is unique then we wont get any registration object associated with it.
				if(r==null)
				{
					//to check whether student id is valid or not. (valid means this id is associated with any student or not. if not associated, that means this id is not valid)
					StudentRepo srp=new StudentRepo();
					Student s=srp.searchStudentByUserId(studentIdTF.getText());
					//if the user id (student id) is valid, then we'll find a student type object.
					if(s!=null)
					{
						//to check whether semester id is valid or not. (valid means this id is associated with any semester or not. if not associated, that means this id is not valid)
						SemesterRepo semrp=new SemesterRepo();
						Semester semester=semrp.searchSemesterBySemesterId(semesterIdTF.getText());
						//if the semester id is valid, then we'll find a student type object.
						if(semester!=null)
						{
							Registration registration=new Registration(registrationIdTF.getText(),studentIdTF.getText(),semesterIdTF.getText(),0,0,0,dateTF.getText());
							//rrp is a Registration repo type object.
							rrp.addRegistration(registration);
							FacultySectionRegistrationLineFrame fhf=new FacultySectionRegistrationLineFrame(this.u,registration);
							this.setVisible(false);
							fhf.setVisible(true);
						}
						
						else
						{
							JOptionPane.showMessageDialog(this,"No semester found!");
						}
						
						
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"No student found!");
					}
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Registration Id is already used!");
				}
				
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to Faculty home page.
			FacultyHomeFrame fhf=new FacultyHomeFrame(this.u);
			this.setVisible(false);
			fhf.setVisible(true);
		}
	}
	
}