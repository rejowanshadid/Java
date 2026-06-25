package entities;
import java.lang.*;

public class Registration
{
	private String registrationId, userId, semesterId, registrationDate;
	private int totalAmount, paidAmount, due; 
	
	public Registration()
	{
	}
	
	public Registration(String registrationId, String userId, String semesterId, int totalAmount, int paidAmount, int due, String registrationDate)
	{
		this.registrationId=registrationId;
		this.userId=userId;
		this.semesterId=semesterId;
		this.totalAmount=totalAmount;
		this.paidAmount=paidAmount;
		this.due=due;
		this.registrationDate=registrationDate;
	}
	
	public void setRegistrationId(String registrationId)
	{
		this.registrationId=registrationId;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setSemesterId(String semesterId)
	{
		this.semesterId=semesterId;
	}
	
	public void setTotalAmount(int totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	
	public void setPaidAmount(int paidAmount)
	{
		this.paidAmount=paidAmount;
	}
	
	public void setDue(int due)
	{
		this.due=due;
	}
	
	public void setRegistrationDate(String registrationDate)
	{
		this.registrationDate=registrationDate;
	}
	
	public String getRegistrationId()
	{
		return this.registrationId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getSemesterId()
	{
		return this.semesterId;
	}
	
	public int getTotalAmount()
	{
		return this.totalAmount;
	}
	
	public int getPaidAmount()
	{
		return this.paidAmount;
	}

	public int getDue()
	{
		return this.due;
	}
	
	public String getRegistrationDate()
	{
		return this.registrationDate;
	}
	
	public String toStringRegistration()
	{
		String str=this.registrationId+","+this.userId+","+this.semesterId+","+this.totalAmount+","+this.paidAmount+","+this.due+","+this.registrationDate+"\n";
		return str;
	}
	
	public Registration formRegistration(String str)
	{
		String[] info=str.split(",");
		
		Registration r=new Registration();
		r.setRegistrationId(info[0]);
		r.setUserId(info[1]);
		r.setSemesterId(info[2]);
		r.setTotalAmount(Integer.parseInt(info[3]));
		r.setPaidAmount(Integer.parseInt(info[4]));
		r.setDue(Integer.parseInt(info[5]));
		r.setRegistrationDate(info[6]);
		
		return r;
		
	}
}