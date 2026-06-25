package entities;
import java.lang.*;

public class Notice
{
	private String noticeId, sectionId, userId, message;
	
	public Notice()
	{
	}
	
	public Notice(String noticeId, String sectionId, String userId, String message)
	{
		this.noticeId=noticeId;
		this.sectionId=sectionId;
		this.userId=userId;
		this.message=message;
	}
	
	public void setNoticeId(String noticeId)
	{
		this.noticeId=noticeId;
	}
	
	public void setSectionId(String sectionId)
	{
		this.sectionId=sectionId;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setMessage(String message)
	{
		this.message=message;
	}
	
	public String getNoticeId()
	{
		return this.noticeId;
	}
	
	public String getSectionId()
	{
		return this.sectionId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getMessage()
	{
		return this.message;
	}
	
	public String toStringNotice()
	{
		String str=this.noticeId+","+this.sectionId+","+this.userId+","+this.message+"\n";
		return str;
	}
	
	public Notice formNotice(String str)
	{
		String[] info=str.split(",");
		
		Notice n=new Notice();
		n.setNoticeId(info[0]);
		n.setSectionId(info[1]);
		n.setUserId(info[2]);
		n.setMessage(info[3]);
		return n;
		
	}
}