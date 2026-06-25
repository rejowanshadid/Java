package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class StudentHomeFrame extends JFrame implements ActionListener
{
	
	private JButton selfCompletedCourseBtn, OfferedCourseBtn, doRegistrationBtn, doPaymentBtn, selfPaymentBtn, OfferedSection, noticeBtn, profileBtn, passBtn;
	private JPanel panel;
	private User u;
	public StudentHomeFrame(User u)
	{
		super("Student Home Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.selfCompletedCourseBtn=new JButton("Self-Completed Course");
		this.selfCompletedCourseBtn.setBounds(50,50,200,30);
		this.selfCompletedCourseBtn.addActionListener(this);
		this.panel.add(selfCompletedCourseBtn);
		
		this.OfferedCourseBtn=new JButton("Offered Course");
		this.OfferedCourseBtn.setBounds(270,50,200,30);
		this.OfferedCourseBtn.addActionListener(this);
		this.panel.add(OfferedCourseBtn);
		
		
		this.doRegistrationBtn=new JButton("Registration");
		this.doRegistrationBtn.setBounds(490,50,200,30);
		this.doRegistrationBtn.addActionListener(this);
		this.panel.add(doRegistrationBtn);
		
		
		this.selfPaymentBtn=new JButton("payment list");
		this.selfPaymentBtn.setBounds(50,100,200,30);
		this.selfPaymentBtn.addActionListener(this);
		this.panel.add(selfPaymentBtn);
		
		
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
		
		if(command.equals(selfPaymentBtn.getText()))
		{
			StudentSelfPaymentListFrame spl=new StudentSelfPaymentListFrame(this.u);
			this.setVisible(false);
			spl.setVisible(true);
		}
	}
	
}
