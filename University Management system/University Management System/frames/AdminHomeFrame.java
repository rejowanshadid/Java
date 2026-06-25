package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	
	private JButton adminBtn, studentBtn, facultyBtn, courseBtn, semesterBtn,sectionBtn,offerCourseBtn, registrationBtn, registrationLineBtn, paymentBtn, profileBtn, passBtn;
	private JPanel panel;
	private User u;
	
	public AdminHomeFrame(User u)
	{
		
		super("Admin Home Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.adminBtn=new JButton("Admin operation");
		this.adminBtn.setBounds(50,50,150,30);
		this.adminBtn.addActionListener(this);
		this.panel.add(adminBtn);
		
		this.studentBtn=new JButton("Student operation");
		this.studentBtn.setBounds(210,50,150,30);
		this.studentBtn.addActionListener(this);
		this.panel.add(studentBtn);
		
		this.facultyBtn=new JButton("Faculty operation");
		this.facultyBtn.setBounds(370,50,150,30);
		this.facultyBtn.addActionListener(this);
		this.panel.add(facultyBtn);
		
		this.courseBtn=new JButton("Course operation");
		this.courseBtn.setBounds(530,50,150,30);
		this.courseBtn.addActionListener(this);
		this.panel.add(courseBtn);
		
		this.semesterBtn=new JButton("Semester operation");
		this.semesterBtn.setBounds(50,100,150,30);
		this.semesterBtn.addActionListener(this);
		this.panel.add(semesterBtn);
		
		this.sectionBtn=new JButton("Section operation");
		this.sectionBtn.setBounds(210,100,150,30);
		this.sectionBtn.addActionListener(this);
		this.panel.add(sectionBtn);
		
		this.offerCourseBtn=new JButton("Offer-course operation");
		this.offerCourseBtn.setBounds(370,100,200,30);
		this.offerCourseBtn.addActionListener(this);
		this.panel.add(offerCourseBtn);
		
		this.registrationBtn=new JButton("view all registration");
		this.registrationBtn.setBounds(580,100,200,30);
		this.registrationBtn.addActionListener(this);
		this.panel.add(registrationBtn);
		
		this.registrationLineBtn=new JButton("view all reg-Line");
		this.registrationLineBtn.setBounds(50,150,200,30);
		this.registrationLineBtn.addActionListener(this);
		this.panel.add(registrationLineBtn);
		
		this.registrationLineBtn=new JButton("view all reg-Line");
		this.registrationLineBtn.setBounds(50,150,200,30);
		this.registrationLineBtn.addActionListener(this);
		this.panel.add(registrationLineBtn);
		
		this.paymentBtn=new JButton("view all Payment");
		this.paymentBtn.setBounds(270,150,200,30);
		this.paymentBtn.addActionListener(this);
		this.panel.add(paymentBtn);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(490,150,150,30);
		this.profileBtn.addActionListener(this);
		this.panel.add(profileBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(660,150,130,30);
		this.passBtn.addActionListener(this);
		this.panel.add(passBtn);
		
		
		
		
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(adminBtn.getText()))
		{
			AdminOperationFrame aof=new AdminOperationFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(paymentBtn.getText()))
		{
			AdminAllPayment aof=new AdminAllPayment(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(profileBtn.getText()))
		{
			AdminUpdateProfileFrame aof=new AdminUpdateProfileFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(passBtn.getText()))
		{
			AdminUpdatePasswordFrame aof=new AdminUpdatePasswordFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		
		
	}
	
}
