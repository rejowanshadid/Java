package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class FacultySectionRegistrationLineFrame extends JFrame implements ActionListener
{
	private JLabel registrationIdLabel, registrationLineIdLabel, sectionIdLabel;
	private JTextField registrationIdTF, registrationLineIdTF, sectionIdTF;
	private JButton addSectionBtn, deleteSectionBtn, cancelRegistrationBtn, loadBtn;
	private JTable registrationTable;
	private JScrollPane registrationTableSP;
	private JTable registrationLineTable;
	private JScrollPane registrationLineTableSP;
	private JPanel panel;
	private User u;
	private Registration r;
	
	
	
	public FacultySectionRegistrationLineFrame(User u, Registration r)
	{
		super("Faculty Registration Line Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.u=u;
		this.r=r;
		
		this.registrationIdLabel=new JLabel("Registration Id:");
		this.registrationIdLabel.setBounds(50,50,100,30);
		this.panel.add(registrationIdLabel);
		
		this.registrationIdTF=new JTextField();
		this.registrationIdTF.setBounds(170,50,100,30);
		this.registrationIdTF.setText(r.getRegistrationId());
		this.registrationIdTF.setEditable(false);
		this.panel.add(registrationIdTF);
		
		this.registrationLineIdLabel=new JLabel("Registration Line Id:");
		this.registrationLineIdLabel.setBounds(50,100,150,30);
		this.panel.add(registrationLineIdLabel);
		
		this.registrationLineIdTF=new JTextField();
		this.registrationLineIdTF.setBounds(220,100,100,30);
		this.panel.add(registrationLineIdTF);
		
		this.sectionIdLabel=new JLabel("Section Id:");
		this.sectionIdLabel.setBounds(50,150,100,30);
		this.panel.add(sectionIdLabel);
		
		this.sectionIdTF=new JTextField();
		this.sectionIdTF.setBounds(170,150,150,30);
		this.panel.add(sectionIdTF);
		
		
		
		this.addSectionBtn=new JButton("Add Section");
		this.addSectionBtn.setBounds(50,250,200,30);
		this.addSectionBtn.addActionListener(this);
		this.panel.add(addSectionBtn);
		
		
		this.cancelRegistrationBtn=new JButton("Cancel Registration");
		this.cancelRegistrationBtn.setBounds(50,300,200,30);
		this.cancelRegistrationBtn.addActionListener(this);
		this.panel.add(cancelRegistrationBtn);
		
		this.loadBtn=new JButton("Reload");
		this.loadBtn.setBounds(290,300,100,30);
		this.loadBtn.addActionListener(this);
		this.panel.add(loadBtn);
		
		//converting the current registration information  in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String registrationData1[][]=new String[1][7];
		registrationData1[0][0]=r.getRegistrationId();
		registrationData1[0][1]=r.getUserId();
		registrationData1[0][2]=r.getSemesterId();
		registrationData1[0][3]=String.valueOf(r.getTotalAmount());
		registrationData1[0][4]=String.valueOf(r.getPaidAmount());
		registrationData1[0][5]=String.valueOf(r.getDue());
		registrationData1[0][6]=r.getRegistrationDate();
		
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Reg. Id","S. Id.","Sem. Id","Tot. Amo.","Paid Amo.","Due","Date"};
		//putting value and colomn name in the table.
		this.registrationTable=new JTable(registrationData1,head1);
		//adding scrolling bar in the table
		this.registrationTableSP=new JScrollPane(registrationTable);
		this.registrationTableSP.setBounds(50,400,650,50);
		this.registrationTable.setEnabled(false);
		this.panel.add(registrationTableSP);
		this.panel.revalidate();
		this.panel.repaint();
		
		//getting all the RegistrationLine info in RegistrationLine type array associated with the registration id
		RegistrationLineRepo rlrp=new RegistrationLineRepo();
		RegistrationLine[] registrationLineList=rlrp.searchRegistrationLineByRegistrationId(r.getRegistrationId());
		//converting the registrationLine type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String registrationLineData[][]=new String[registrationLineList.length][4];
		for(int i=0;i<registrationLineList.length;i++)
		{
		
			if(registrationLineList[i]!=null)
			{
				registrationLineData[i][0]=registrationLineList[i].getRegistrationLineId();
				registrationLineData[i][1]=registrationLineList[i].getRegistrationId();
				registrationLineData[i][2]=registrationLineList[i].getSectionId();
				registrationLineData[i][3]=String.valueOf(registrationLineList[i].getTotalAmount());
			
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head2[]={"Reg Line Id","Reg. Id","Sec. Id","Tot. Amo."};
		//putting value and colomn name in the table.
		this.registrationLineTable=new JTable(registrationLineData,head2);
		//adding scrolling bar in the table
		this.registrationLineTableSP=new JScrollPane(registrationLineTable);
		this.registrationLineTableSP.setBounds(350,50,440,100);
		this.registrationLineTable.setEnabled(false);
		this.panel.add(registrationLineTableSP);
		this.panel.revalidate();
		this.panel.repaint();
		
		
		
		
		this.add(panel);
		
		
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(addSectionBtn.getText()))
		{
			//validating every field has data or not
			if((!registrationLineIdTF.getText().isEmpty()) && (!sectionIdTF.getText().isEmpty()))
			{
				//to check whether the provided registrationLine id is unique or not, we need to search it on registrationLine.txt.
				RegistrationLineRepo rlrepo=new RegistrationLineRepo();
				RegistrationLine regL=rlrepo.searchRegistrationLineByRegistrationLineId(registrationLineIdTF.getText());
				//if no object is found, that means the id is unique.
				if(regL==null)
				{
					//we need to check the provided section id is valid and associated with any section object. 
					SectionRepo scrp=new SectionRepo();
					Section sc=scrp.searchSectionBySectionId(sectionIdTF.getText());
					//if any object is found, that means the section id is valid.
					if(sc!=null)
					{
						//we need to find out the course, that is associated with the section, because no of credit and per credit fee is need to calculate total amount.
						CourseRepo crsrp=new CourseRepo();
						//searching a course.
						//section class has an attribute name is course Id, using that attribute, we performing the search.
						Course crs=crsrp.searchCourseByCourseId(sc.getCourseId()); 
						//creating a registrationline object to write information in the registration line txt.
						RegistrationLine registrationLine=new RegistrationLine(registrationLineIdTF.getText(),registrationIdTF.getText(),sectionIdTF.getText(),(crs.getNoOfCredit()*crs.getPerCreditFee()));
						RegistrationLineRepo regLineRepo=new RegistrationLineRepo();
						regLineRepo.addRegistrationLine(registrationLine);
						//if a student register for a section, that means numberOfStudents attribute will be increased, and availableSeat will be decreased.
						int numberOfStudents=sc.getNumberOfStudents();
						int availableSeat=sc.getAvailableSeat();
			            //updating the section class attributes
						sc.setNumberOfStudents(numberOfStudents+1);
						sc.setAvailableSeat(availableSeat-1);
						scrp.updateSection(sc);
						
						//updating the registrtaion attributes. because when a student takes a new section, then his total amount will be updated according to the total amount of that section.
						int totalAmount=r.getTotalAmount();
						r.setTotalAmount(totalAmount+registrationLine.getTotalAmount());
						RegistrationRepo rRepo=new RegistrationRepo();
						rRepo.updateRegistration(r);
						
						this.refresh();
						
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Section not found.");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"RegistrationLineId is already Used.");
				}
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(cancelRegistrationBtn.getText()))
		{
			//back button will take you to Faculty home page.
			FacultyHomeFrame fhf=new FacultyHomeFrame(this.u);
			this.setVisible(false);
			fhf.setVisible(true);
		}
		
		if(command.equals(loadBtn.getText()))
		{
			//reloading the page.
			FacultySectionRegistrationLineFrame fhf=new FacultySectionRegistrationLineFrame(this.u,this.r);
			this.setVisible(false);
			fhf.setVisible(true);
		}
		
		
	}
	
	public void refresh()
	{
		FacultySectionRegistrationLineFrame fhf=new FacultySectionRegistrationLineFrame(this.u,this.r);
		this.setVisible(false);
		fhf.setVisible(true);
	}
	
}