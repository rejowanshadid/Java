package entities;
import java.lang.*;

public class Course
{
	private String courseId, courseName, departmentId;
	private int noOfCredit, perCreditFee;
	
	public Course()
	{
	}
	
	public Course(String courseId, String courseName, String departmentId, int noOfCredit, int perCreditFee)
	{
		this.courseId=courseId;
		this.courseName=courseName;
		this.departmentId=departmentId;
		this.noOfCredit=noOfCredit;
		this.perCreditFee=perCreditFee;
	}
	
	public void setCourseId(String courseId)
	{
		this.courseId=courseId;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName=courseName;
	}
	
	public void setDepartmentId(String departmentId)
	{
		this.departmentId=departmentId;
	}
	
	public void setNoOfCredit(int noOfCredit)
	{
		this.noOfCredit=noOfCredit;
	}
	
	public void setPerCreditFee(int perCreditFee)
	{
		this.perCreditFee=perCreditFee;
	}
	
	public String getCourseId()
	{
		return this.courseId;
	}
	
	public String getCourseName()
	{
		return this.courseName;
	}
	
	public String getDepartmentId()
	{
		return this.departmentId;
	}
	
	public int getNoOfCredit()
	{
		return this.noOfCredit;
	}
	
	public int getPerCreditFee()
	{
		return this.perCreditFee;
	}
	
	public String toStringCourse()
	{
		String str=this.courseId+","+this.courseName+","+this.departmentId+","+this.noOfCredit+","+this.perCreditFee+"\n";
		return str;
	}
	
	public Course formCourse(String str)
	{
		String[] info=str.split(",");
		Course c=new Course();
		c.setCourseId(info[0]);
		c.setCourseName(info[1]);
		c.setDepartmentId(info[2]);
		c.setNoOfCredit(Integer.parseInt(info[3]));
		c.setPerCreditFee(Integer.parseInt(info[4]));
		return c;
	}
}