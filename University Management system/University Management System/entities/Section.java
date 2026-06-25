package entities;
import java.lang.*;

public class Section
{
	private String sectionId, sectionName, userId, courseId, semesterId, classTime, sectionStatus;
	private int totalSeat, numberOfStudents, availableSeat;
	
	public Section()
	{
	}
	
	public Section(String sectionId, String sectionName, String userId, String courseId, String semesterId, int totalSeat, int numberOfStudents, int availableSeat, String classTime, String sectionStatus)
	{
		this.sectionId=sectionId;
		this.sectionName=sectionName;
		this.userId=userId;
		this.courseId=courseId;
		this.semesterId=semesterId;
		this.totalSeat=totalSeat;
		this.numberOfStudents=numberOfStudents;
		this.availableSeat=availableSeat;
		this.classTime=classTime;
		this.sectionStatus=sectionStatus;
	}
	
	public void setSectionId(String sectionId)
	{
		this.sectionId=sectionId;
	}
	
	public void setSectionName(String sectionName)
	{
		this.sectionName=sectionName;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setSemesterId(String semesterId)
	{
		this.semesterId=semesterId;
	}
	
	public void setCourseId(String courseId)
	{
		this.courseId=courseId;
	}
	
	public void setTotalSeat(int totalSeat)
	{
		this.totalSeat=totalSeat;
	}
	
	public void setNumberOfStudents(int numberOfStudents)
	{
		this.numberOfStudents=numberOfStudents;
	}
	
	public void setAvailableSeat(int availableSeat)
	{
		this.availableSeat=availableSeat;
	}
	
	public void setClassTime(String classTime)
	{
		this.classTime=classTime;
	}
	
	public void setSectionStatus(String sectionStatus)
	{
		this.sectionStatus=sectionStatus;
	}
	
	public String getSectionId()
	{
		return this.sectionId;
	}
	
	public String getSectionName()
	{
		return this.sectionName;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getSemesterId()
	{
		return this.semesterId;
	}
	
	public String getCourseId()
	{
		return this.courseId;
	}
	
	public int getTotalSeat()
	{
		return this.totalSeat;
	}
	
	public int getNumberOfStudents()
	{
		return this.numberOfStudents;
	}
	
	public int getAvailableSeat()
	{
		return this.availableSeat;
	}
	
	public String getClassTime()
	{
		return this.classTime;
	}
	
	public String getSectionStatus()
	{
		return this.sectionStatus;
	}
	
	public String toStringSection()
	{
		String str=this.sectionId+","+this.sectionName+","+this.userId+","+this.courseId+","+this.semesterId+","+this.totalSeat+","+this.numberOfStudents+","+this.availableSeat+","+this.classTime+","+this.sectionStatus+"\n";
		return str;
	}
	
	public Section formSection(String str)
	{
		String[] info=str.split(",");
		
		Section s=new Section();
		s.setSectionId(info[0]);
		s.setSectionName(info[1]);
		s.setUserId(info[2]);
		s.setCourseId(info[3]);
		s.setSemesterId(info[4]);
		s.setTotalSeat(Integer.parseInt(info[5]));
		s.setNumberOfStudents(Integer.parseInt(info[6]));
		s.setAvailableSeat(Integer.parseInt(info[7]));
		s.setClassTime(info[8]);
		s.setSectionStatus(info[9]);
		
		return s;
		
	}
	
	
}