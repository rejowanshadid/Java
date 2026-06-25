package entities;
import java.lang.*;

public class RegistrationLine
{
	private String registrationLineId, registrationId, sectionId;
	private int totalAmount;
	
	public RegistrationLine()
	{
	}
	
	public RegistrationLine(String registrationLineId, String registrationId, String sectionId, int totalAmount)
	{
		this.registrationLineId=registrationLineId;
		this.registrationId=registrationId;
		this.sectionId=sectionId;
		this.totalAmount=totalAmount;
	}
	
	
	public void setRegistrationLineId(String registrationLineId)
	{
		this.registrationLineId=registrationLineId;
	}
	
	public void setRegistrationId(String registrationId)
	{
		this.registrationId=registrationId;
	}
	
	public void setSectionId(String sectionId)
	{
		this.sectionId=sectionId;
	}
	
	public void setTotalAmount(int totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	
	public String getRegistrationLineId()
	{
		return this.registrationLineId;
	}
	
	public String getRegistrationId()
	{
		return this.registrationId;
	}
	
	public String getSectionId()
	{
		return this.sectionId;
	}
	
	public int getTotalAmount()
	{
		return this.totalAmount;
	}
	
	public String toStringRegistrationLine()
	{
		String str=this.registrationLineId+","+this.registrationId+","+this.sectionId+","+this.totalAmount+"\n";
		return str;
	}
	
	public RegistrationLine formRegistrationLine(String str)
	{
		String[] info=str.split(",");
		
		RegistrationLine rl=new RegistrationLine();
		rl.setRegistrationLineId(info[0]);
		rl.setRegistrationId(info[1]);
		rl.setSectionId(info[2]);
		rl.setTotalAmount(Integer.parseInt(info[3]));
		
		return rl;
		
	}
}