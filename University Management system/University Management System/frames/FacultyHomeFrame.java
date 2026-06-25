package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class FacultyHomeFrame extends JFrame implements ActionListener
{
	
	private JButton studentBtn, selfCourseBtn, studentSectionBtn, doRegistrationBtn, profileBtn, passBtn;
	private JPanel panel;
	private User u;
	
	public FacultyHomeFrame(User u)
	{
		super("Faculty Home Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.studentBtn=new JButton("Student operation");
		this.studentBtn.setBounds(50,50,150,30);
		this.studentBtn.addActionListener(this);
		this.panel.add(studentBtn);
		
		
		this.selfCourseBtn=new JButton("Self Course");
		this.selfCourseBtn.setBounds(220,50,150,30);
		this.selfCourseBtn.addActionListener(this);
		this.panel.add(selfCourseBtn);
		
		
		this.studentSectionBtn=new JButton("Student-Section");
		this.studentSectionBtn.setBounds(390,50,150,30);
		this.studentSectionBtn.addActionListener(this);
		this.panel.add(studentSectionBtn);
		
	
		
		this.doRegistrationBtn=new JButton("Do Registration");
		this.doRegistrationBtn.setBounds(50,100,200,30);
		this.doRegistrationBtn.addActionListener(this);
		this.panel.add(doRegistrationBtn);
		
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(270,100,150,30);
		this.profileBtn.addActionListener(this);
		this.panel.add(profileBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(440,100,130,30);
		this.passBtn.addActionListener(this);
		this.panel.add(passBtn);
		
		
		
		
		
		this.add(panel);
		
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(doRegistrationBtn.getText()))
		{
			FacultySectionRegistrationFrame fsrf= new FacultySectionRegistrationFrame(this.u);
			this.setVisible(false);
			fsrf.setVisible(true);
		}
	}
	
}
