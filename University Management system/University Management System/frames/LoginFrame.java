package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, signUpBtn, forgetPassBtn;
	private JPanel panel;
	
	public LoginFrame()
	{
		super("Login Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,20);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,45,100,30);
		this.panel.add(userTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(50,90,800,20);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(120,85,100,30);
		this.panel.add(passPF);
		
		this.loginBtn=new JButton("Login");
		this.loginBtn.setBounds(50,130,100,30);
		this.loginBtn.addActionListener(this);
		this.panel.add(loginBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(160,130,60,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.signUpBtn=new JButton("Sign Up");
		this.signUpBtn.setBounds(50,170,130,30);
		this.signUpBtn.addActionListener(this);
		this.panel.add(signUpBtn);
		
		this.forgetPassBtn=new JButton("Forget Pass");
		this.forgetPassBtn.setBounds(190,170,130,30);
		this.forgetPassBtn.addActionListener(this);
		this.panel.add(forgetPassBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			String uId=userTF.getText();
			String pass=passPF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUserByUserId(uId);
			if(user!=null)
			{
				if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==1)
				{
					AdminHomeFrame ahf=new AdminHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==2)
				{
					FacultyHomeFrame ahf=new FacultyHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==3)
				{
					StudentHomeFrame ahf=new StudentHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				
				
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
				}
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
			}
		}
		
		if(command.equals(signUpBtn.getText()))
		{
			SignUpFrame sf=new SignUpFrame();
			this.setVisible(false);
			sf.setVisible(true);
		}
		
		if(command.equals(forgetPassBtn.getText()))
		{
			ForgetPassFrame fpf=new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
