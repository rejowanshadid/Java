package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox adminTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,100,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,250,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(280,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(350,50,100,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,150,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(280,250,100,30);
		this.panel.add(adminTypeLabel);
		
		String[] item={"Hr Admin", "Academic Admin"};
		this.adminTypeCMB=new JComboBox(item);
		this.adminTypeCMB.setBounds(390,250,200,30);
		this.panel.add(adminTypeCMB);
		
		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Admin");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Admin");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Admin");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		//getting all the admins info in Admin type array
		AdminRepo arp=new AdminRepo();
		Admin[] adminList=arp.getAllAdmin();
		//converting the Admin type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String adminData1[][]=new String[adminList.length][8];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData1[i][0]=adminList[i].getUserId();
				adminData1[i][1]=adminList[i].getName();
				adminData1[i][2]=adminList[i].getEmail();
				adminData1[i][3]=adminList[i].getPhoneNo();
				adminData1[i][4]=adminList[i].getGender();
				adminData1[i][5]=String.valueOf(adminList[i].getAge());
				adminData1[i][6]=adminList[i].getAddress();
				adminData1[i][7]=adminList[i].getAdminType();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","AdminType"};
		//putting value and colomn name in the table.
		this.adminTable=new JTable(adminData1,head1);
		//adding scrolling bar in the table
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(50,380,700,200);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass,adminType;
			int age;
			//validating every field has data or not
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a UserRepo object to perform operation in the user.txt file where we stored user login information
				UserRepo urp=new UserRepo();
				//checking whether the provide user id is unique or already assign to another user.
				User user=urp.searchUserByUserId(userId);
				// if the provided userId is unique, no User type object will be found in the user.txt file.
				//if no user if assign with the userId then we can use the userId for creating new admin.
				if(user==null)
				{
					//using try catch block, so that, any type of exception can be handled. here we have a age value, which is expected to be integer.
					//but user can put string value to age varible which might cause exception.
					//to handle such exception we are using try catch block.
					try
					{
						//asign nameTF textfField value to a name variable.
						name=nameTF.getText();
						//asign emailTF textfField value to a email variable.
						email=emailTF.getText();
						//asign phoneNoTF textfField value to a phoneNo variable.
						phoneNo=phoneNoTF.getText();
						// to get gender, we use RadioButton. now to know which radioButton is selected,
						//we are applying conditions if maleRB is selected, gender variable will be assigned as maleRB's value.
						//if femaleRB is selected, gender variable will be assigned as femaleRB's value.
						//or by default maleRB's value will be assigned.
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						//asign ageTF textfField value to a age variable. But before assigning we have to convert the ageTF value to integer as our age varibale's expected value is integer.
						age=Integer.parseInt(ageTF.getText());
						//asign addressTF textfField value to a address variable.
						address=addressTF.getText();
						//asign role. As all the Admin will have the same role, we won't have to take this value from user.
						//For admin the role will be 1.
						int role=1;
						//asign securityAnsTF textfField value to a securityAns variable.
						securityAns=securityAnsTF.getText();
						//asign passPF PassField value to a pass variable.
						pass=passPF.getText();
						//asign adminTypeCMB comboBox value to a adminType variable.
						adminType=adminTypeCMB.getSelectedItem().toString();
						//Creating a admin type variable with all the values that we get from the fields.
						Admin a=new Admin(userId,name,email,phoneNo,gender,age,address,role,securityAns,pass,adminType);
						//to add admin's user id, security ans, role and pass information in the user.txt file. as without data in the user.txt file, no user will be able to login in.
						//passing admin type object to a userRepo. here polymorphic behaviour of object is used.
						urp.addUser(a);
						//creating a AdminRepo object to perform operation in the admin.txt file where we stored admins information
						AdminRepo arp=new AdminRepo();
						//to add admin's information in the admin.txt file. because all the admins information will be stored there.
						arp.addAdmin(a);
						//After successful add operation a confirmation message will be shown.
						JOptionPane.showMessageDialog(this,"admin added Successfully");
					}
					catch(Exception e)
					{
						//if any exception occured in the above operation, it is beacuse of string to int convertion.
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					//if the provided userId is already assign to any user, this message will be shown.
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,email,phoneNo,gender,address,adminType;
			int age;
			//validating every field has data or not
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a AdminRepo object to perform operation in the admin.txt file where we stored admins information
				AdminRepo arp=new AdminRepo();
				//checking wether the userId is associated with any admin or not.
				//if associated searchAdminByUserId will return an object of admin type
				Admin a=arp.searchAdminByUserId(userId);
				//if a varible has any admin object then next step will be performed. if null, that means no valid admin is associated with the userId.
				if(a!=null)
				{
					//using try catch block, so that, any type of exception can be handled. here we have a age value, which is expected to be integer.
					//but user can put string value to age varible which might cause exception.
					//to handle such exception we are using try catch block.
					try
					{
						//asign updated nameTF textfField value to a name variable.
						name=nameTF.getText();
						//asign upated emailTF textfField value to a email variable.
						email=emailTF.getText();
						//asign upated phoneNo textfField value to a phoneNo variable.
						phoneNo=phoneNoTF.getText();
						// to get gender, we use RadioButton. now to know which radioButton is selected,
						//we are applying conditions if maleRB is selected, gender variable will be assigned as maleRB's value.
						//if femaleRB is selected, gender variable will be assigned as femaleRB's value.
						//or by default maleRB's value will be assigned.
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						//asign updated ageTF textfField value to a age variable. But before assigning we have to convert the ageTF value to integer as our age varibale's expected value is integer.
						age=Integer.parseInt(ageTF.getText());
						//asign updated addressTF textfField value to a address variable.
						address=addressTF.getText();
						//asign updated adminTypeCMB comboBox value to a adminType variable
						adminType=adminTypeCMB.getSelectedItem().toString();
					
						//we are modifying the attributes of admin type object that we get by searing admin by userId.
						a.setName(name);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setGender(gender);
						a.setAge(age);
						a.setAddress(address);
						a.setAdminType(adminType);
						//doing update operation by AdminRepo's object arp.
						arp.updateAdmin(a);
						//updation confirmation message.
						JOptionPane.showMessageDialog(this,"admin updated Successfully");
					}
					catch(Exception e)
					{
						//if any exception occured in the above operation, it is beacuse of string to int convertion.
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					//if any exception occured in the above operation, it is beacuse of string to int convertion.
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			//to delete admin we need to have the user id.
			//validating userTF has data or not
			if(!userTF.getText().isEmpty()) 
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a AdminRepo object to perform operation in the admin.txt file where we stored admins information
				AdminRepo arp=new AdminRepo();
				//checking wether the userId is associated with any admin or not.
				//if associated searchAdminByUserId will return an object of admin type
				Admin a=arp.searchAdminByUserId(userId);
				//if we get an admin associated with the id, we can perform the next steps.
				if(a!=null)
				{
					//if we want to delete an admin, first we have to delete that admin's login credentials which is stored in the user.txt file.
					//creating a UserRepo object to perform operation in the user.txt file where we stored user's login information
					UserRepo urp=new UserRepo();
					//to remove admin's login information from user.txt, we have use the remove user functionality provided by UserRepo.
					urp.removeUser(userId);
					//removing admin from admin.txt.
					arp.removeAdmin(userId);
					//confirmation message of admin remove operation
					JOptionPane.showMessageDialog(this,"Admin removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			//to search admin we need to have the user id.
			//validating userTF has data or not
			if(!userTF.getText().isEmpty())
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a AdminRepo object to perform operation in the admin.txt file where we stored admins information
				AdminRepo urp=new AdminRepo();
				//checking wether the userId is associated with any admin or not.
				//if associated searchAdminByUserId will return an object of admin type
				Admin a=urp.searchAdminByUserId(userId);
				//if we get an admin associated with the id, we can perform the next steps.
				if(a!=null)
				{
					//making userTF textField readonly. beacuse after search, update or delete operation will be performed.
					// to avoid user from modifying userId, we make it readonly.
					userTF.setEditable(false);
					//setting the admin's name in the nameTF textField that we found by searching.
					nameTF.setText(a.getName());
					//setting the admin's email in the emailTF textField that we found by searching. 
					emailTF.setText(a.getEmail());
					//setting the admin's phoneNo in the nameTF textField that we found by searching.
					phoneNoTF.setText(a.getPhoneNo());
					//setting the admin's gender in the maleRB or femaleRB radioButton that we found by searching. 
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					//setting the admin's adminType in the adminTypeCMB comboBox that we found by searching.
					if(a.getAdminType().equals("Hr Admin"))
					{
						adminTypeCMB.setSelectedItem("Hr Admin");
					}
					else
					{
						adminTypeCMB.setSelectedItem("Academic Admin");
					}
					//setting the admin's age in the ageTF textField that we found by searching.
					ageTF.setText(String.valueOf(a.getAge()));
					//setting the admin's address in the addressTF textField that we found by searching.
					addressTF.setText(a.getAddress());
					//Confirmation message if admin is found.
					JOptionPane.showMessageDialog(this,"admin found");
				}
				
				else
				{
					//confirmation message if admin is not found.
					JOptionPane.showMessageDialog(this,"admin not found");
				}
			}
			
			else
			{
				//if no id is assign to perform the search operation.
				JOptionPane.showMessageDialog(this,"Please provide userId to search admin.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			//reseting all the field values.
			//making userId textField editable again.
			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			ageTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"reset successfully");
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