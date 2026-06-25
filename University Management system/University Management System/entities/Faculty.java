package entities;
import java.lang.*;

public class Faculty extends User
{
	private String specialization;
	private int numberOfPapers, salary;
	
	public Faculty()
	{
		super();
	}
	
	public Faculty(String userId, String name, String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password, String specialization,int numberOfPapers, int salary)
	{
		super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
		this.specialization=specialization;
		this.numberOfPapers=numberOfPapers;
		this.salary=salary;
	}
	
	public void setSpecialization(String specialization)
	{
		this.specialization=specialization;
	}
	
	public void setNumberOfPapers(int numberOfPapers)
	{
		this.numberOfPapers=numberOfPapers;
	}
	
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	
	
	public String toStringFaculty()
	{
		String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.specialization+","+this.numberOfPapers+","+this.salary+"\n";
		return str;
	}
	
	public Faculty formFaculty(String str)
	{
		String[] info=str.split(",");
		Faculty f=new Faculty();
		f.setUserId(info[0]);
		f.setName(info[1]);
		f.setEmail(info[2]);
		f.setPhoneNo(info[3]);
		f.setGender(info[4]);
		f.setAge(Integer.parseInt(info[5]));
		f.setAddress(info[6]);
		f.setSpecialization(info[7]);
		f.setNumberOfPapers(Integer.parseInt(info[8]));
		f.setSalary(Integer.parseInt(info[9]));
		
		return f;
	}
	
	
}