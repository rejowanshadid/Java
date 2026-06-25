package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminUpdatePasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,currentPassLabel, newPassLabel;
	private JTextField userTF;
	private JPasswordField currentPassPF,newPassPF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	public AdminUpdatePasswordFrame(User u)
	{
		super("Admin Update Password Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(u.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.currentPassLabel=new JLabel("current Password:");
		this.currentPassLabel.setBounds(50,100,60,30);
		this.panel.add(currentPassLabel);
		
		this.currentPassPF=new JPasswordField();
		this.currentPassPF.setBounds(120,100,100,30);
		this.panel.add(currentPassPF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(50,150,60,30);
		this.panel.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(120,150,100,30);
		this.panel.add(newPassPF);
		
		
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,200,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,200,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			//validating every field has data or not
			if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{
				
				if(currentPassPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPassPF.getText());
					//doing update operation by UserRepo's object urp.
					UserRepo urp=new UserRepo();
					urp.updateUser(u);
					//updation confirmation message.
					JOptionPane.showMessageDialog(this,"Password updated Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Current Password didn't match");
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
			//back button will take you to admin home page.
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}