package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class NoticeRepo implements INoticeRepo
{
	public void addNotice(Notice n)
	{
		Notice[] noticeList=this.getAllNotice();
		
		for(int i=0;i<noticeList.length;i++)
		{
			if(noticeList[i]==null)
			{
				noticeList[i]=n;
				break;
			}
		}
		
		this.write(noticeList);
	}
	public void removeNotice(String key)
	{
		Notice[] noticeList=this.getAllNotice();
		
		for(int i=0;i<noticeList.length;i++)
		{
			if(noticeList[i]!=null)
			{
				if(noticeList[i].getNoticeId().equals(key))
				{
					noticeList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(noticeList);
	}
	public void updateNotice(Notice n)
	{
		Notice[] noticeList=this.getAllNotice();
		
		for(int i=0;i<noticeList.length;i++)
		{
			if(noticeList[i]!=null)
			{
				if(noticeList[i].getNoticeId().equals(n.getNoticeId()))
				{
					noticeList[i]=n;
					break;
				}
			}
			
		}
		
		this.write(noticeList);
	}
	
	
	
	public Notice searchNoticeByNoticeId(String id)
	{
		Notice[] noticeList=this.getAllNotice();
		
		for(int i=0;i<noticeList.length;i++)
		{
			if(noticeList[i]!=null)
			{
				if(noticeList[i].getNoticeId().equals(id))
				{
					return noticeList[i];
				}
			}
			
		}

		return null;
	}
	
	
	
	public Notice[] searchNoticeByUserId(String id)
	{
		Notice[] noticeList=this.getAllNotice();
		Notice[] foundNotice=new Notice[100];
		
		for(int i=0;i<noticeList.length;i++)
		{
			if(noticeList[i]!=null)
			{
				if(noticeList[i].getUserId().equals(id))
				{
					foundNotice[i]=noticeList[i];
				}
			}
			
		}

		return foundNotice;
	}
	
	public Notice[] searchNoticeBySectionId(String id)
	{
		Notice[] noticeList=this.getAllNotice();
		Notice[] foundNotice=new Notice[100];
		
		for(int i=0;i<noticeList.length;i++)
		{
			if(noticeList[i]!=null)
			{
				if(noticeList[i].SectionId().equals(id))
				{
					foundNotice[i]=noticeList[i];
				}
			}
			
		}

		return foundNotice;
	}
	

	
	public Notice[] getAllNotice()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/notice.txt");
		
		
		Notice n=new Notice();
		Notice[] noticeList=new Notice[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				noticeList[i]=n.formNotice(str);
				
			}
			
			i++;
		}
		
		return noticeList;
	}
	
	public void write(Notice[] noticeList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(noticeList[i]!=null)
			{
				data[i]=noticeList [i].toStringNotice();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/notice.txt");
	}
}