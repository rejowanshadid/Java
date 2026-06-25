package entities;
import java.lang.*;

public class StudentSection
{
	
	private String studentSectionId, sectionId, studentId;
	private float gpa;
	
	public StudentSection()
	{
		
	}
	
	public  StudentSection(String studentSectionId, String sectionId, String studentId,float gpa)
	{
		this.studentSectionId=studentSectionId;
		this.sectionId=sectionId;
		this.studentId=studentId;
		this.gpa=gpa;
	}
	
	public void setStudentSectionId(String studentSectionId)
	{
		this.studentSectionId=studentSectionId;
	}
	
	public void setSectionId(String sectionId)
	{
		this.sectionId=sectionId;
	}
	
	public void setStudentId(String studentId)
	{
		this.studentId=studentId;
	}
	
	public void setGpa(float gpa)
	{
		this.gpa=gpa;
	}
	
	public String getStudentSectionId()
	{
		return this.studentSectionId;
	}
	
	public String getSectionId()
	{
		return this.sectionId;
	}
	
	public String getStudentId()
	{
		return this.studentId;
	}
	
	public float getGpa()
	{
		return this.gpa;
	}
	
	
	public String toStringStudentSection()
	{
		String str=this.studentSectionId+","+this.sectionId+","+this.studentId+","+this.gpa+"\n";
		return str;
	}
	
	public StudentSection formStudentSection(String str)
	{
		String[] info=str.split(",");
		StudentSection ss=new StudentSection();
		ss.setStudentSectionId(info[0]);
		ss.setSectionId(info[1]);
		ss.setStudentId(info[2]);
		ss.setGpa(Float.parseFloat(info[3]));
		return ss;
	}
	
	
}