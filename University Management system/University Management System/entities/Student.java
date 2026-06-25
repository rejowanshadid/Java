package entities;
import java.lang.*;

public class Student extends User
{
	private int completedCredit;
	private float cgpa;
	
	public Student()
	{
		super();
	}
	
	public Student(String userId, String name, String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password, int completedCredit,float cgpa)
	{
		super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
		this.completedCredit=completedCredit;
		this.cgpa=cgpa;
	}
	
	public void setCompletdCredit(int completedCredit)
	{
		this.completedCredit=completedCredit;
	}
	
	public void setCgpa(float cgpa)
	{
		this.cgpa=cgpa;
	}
	
	public int getCompletdCredit()
	{
		return this.completedCredit;
	}
	
	public float getCgpa()
	{
		return this.cgpa;
	}
	
	
	public String toStringStudent()
	{
		String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.completedCredit+","+this.cgpa+"\n";
		return str;
	}
	
	public Student formStudent(String str)
	{
		String[] info=str.split(",");
		Student s=new Student();
		s.setUserId(info[0]);
		s.setName(info[1]);
		s.setEmail(info[2]);
		s.setPhoneNo(info[3]);
		s.setGender(info[4]);
		s.setAge(Integer.parseInt(info[5]));
		s.setAddress(info[6]);
		s.setCompletdCredit(Integer.parseInt(info[7]));
		s.setCgpa(Float.parseFloat(info[8]));
		
		return s;
	}
	
	
}