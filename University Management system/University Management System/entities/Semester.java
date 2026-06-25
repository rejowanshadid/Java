package entities;
import java.lang.*;

public class Semester
{
	private String semesterId, semesterName, startDate, endDate; 
	private int durationInMonth;
	
	public Semester()
	{
	}
	
	public Semester(String semesterId, String semesterName, String startDate, String endDate, int durationInMonth)
	{
		this.semesterId=semesterId;
		this.semesterName=semesterName;
		this.startDate=startDate;
		this.endDate=endDate;
		this.durationInMonth=durationInMonth;
	}
	
	public void setSemesterId(String semesterId)
	{
		this.semesterId=semesterId;
	}
	
	public void setSemesterName(String semesterName)
	{
		this.semesterName=semesterName;
	}
	
	public void setStartDate(String startDate)
	{
		this.startDate=startDate;
	}
	
	public void setEndDate(String endDate)
	{
		this.endDate=endDate;
	}
	
	public void setDurationInMonth(int durationInMonth)
	{
		this.durationInMonth=durationInMonth;
	}
	
	public String getSemesterId()
	{
		return this.semesterId;
	}
	
	public String getSemesterName()
	{
		return this.semesterName;
	}
	
	public String getStartDate()
	{
		return this.startDate;
	}
	
	public String getEndDate()
	{
		return this.endDate;
	}
	
	public int getDurationInMonth()
	{
		return this.durationInMonth;
	}
	
	public String toStringSemester()
	{
		String str=this.semesterId+","+this.semesterName+","+this.startDate+","+this.endDate+","+this.durationInMonth+"\n";
		return str;
	}
	
	public Semester formSemester(String str)
	{
		String[] info=str.split(",");
		Semester s=new Semester();
		s.setSemesterId(info[0]);
		s.setSemesterName(info[1]);
		s.setStartDate(info[2]);
		s.setEndDate(info[3]);
		s.setDurationInMonth(Integer.parseInt(info[4]));
		return s;
		
	}
	
	
}