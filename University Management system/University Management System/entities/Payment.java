package entities;
import java.lang.*;


public class Payment
{
	private String paymentId, registrationId, userId, paymentDate;
	private int paidAmount;
	
	public Payment()
	{
	}
	
	public Payment(String paymentId, String registrationId, String userId, int paidAmount, String paymentDate)
	{
		this.paymentId=paymentId;
		this.registrationId=registrationId;
		this.userId=userId;
		this.paidAmount=paidAmount;
		this.paymentDate=paymentDate;
	}
	
	public void setPaymentId(String paymentId)
	{
		this.paymentId=paymentId;
	}
	
	public void setRegistrationId(String registrationId)
	{
		this.registrationId=registrationId;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setPaidAmount(int paidAmount)
	{
		this.paidAmount=paidAmount;
	}
	
	public void setPaymentDate(String paymentDate)
	{
		this.paymentDate=paymentDate;
	}
	
	public String getPaymentId()
	{
		return this.paymentId;
	}
	
	public String getRegistrationId()
	{
		return this.registrationId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public int getPaidAmount()
	{
		return this.paidAmount;
	}
	
	public String getPaymentDate()
	{
		return this.paymentDate;
		
	}
	
	public String toStringPayment()
	{
		String str=this.paymentId+","+this.registrationId+","+this.userId+","+this.paidAmount+","+this.paymentDate+","+"\n";
		return str;
	}
	
	public Payment formPayment(String str)
	{
		String[] info=str.split(",");
		
		Payment p=new Payment();
		p.setPaymentId(info[0]);
		p.setRegistrationId(info[1]);
		p.setUserId(info[2]);
		p.setPaidAmount(Integer.parseInt(info[3]));
		p.setPaymentDate(info[4]);
		
		return p;
		
	}
	
	
	
	
	
	
	
	
}