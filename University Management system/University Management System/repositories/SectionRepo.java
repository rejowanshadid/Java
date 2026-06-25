package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class SectionRepo implements ISectionRepo
{
	public void addSection(Section s)
	{
		Section[] sectionList=this.getAllSection();
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]==null)
			{
				sectionList[i]=s;
				break;
			}
		}
		
		this.write(sectionList);
	}
	public void removeSection(String key)
	{
		Section[] sectionList=this.getAllSection();
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]!=null)
			{
				if(sectionList[i].getSectionId().equals(key))
				{
					sectionList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(sectionList);
	}
	public void updateSection(Section s)
	{
		Section[] sectionList=this.getAllSection();
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]!=null)
			{
				if(sectionList[i].getSectionId().equals(s.getSectionId()))
				{
					sectionList[i]=s;
					break;
				}
			}
			
		}
		
		this.write(sectionList);
	}
	public Section searchSectionBySectionId(String id)
	{
		Section[] sectionList=this.getAllSection();
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]!=null)
			{
				if(sectionList[i].getSectionId().equals(id))
				{
					return sectionList[i];
				}
			}
			
		}

		return null;
	}
	
	public Section[] searchSectionByUserId(String id)
	{
		Section[] sectionList=this.getAllSection();
		Section[] foundSection=new Section[100];
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]!=null)
			{
				if(sectionList[i].getUserId().equals(id))
				{
					foundSection[i]=sectionList[i];
				}
			}
			
		}

		return foundSection;
	}
	
	public Section[] searchSectionBySemesterId(String id)
	{
		Section[] sectionList=this.getAllSection();
		Section[] foundSection=new Section[100];
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]!=null)
			{
				if(sectionList[i].getSemesterId().equals(id))
				{
					foundSection[i]=sectionList[i];
				}
			}
			
		}

		return foundSection;
	}
	
	public Section[] searchSectionByCourseId(String id)
	{
		Section[] sectionList=this.getAllSection();
		Section[] foundSection=new Section[100];
		
		for(int i=0;i<sectionList.length;i++)
		{
			if(sectionList[i]!=null)
			{
				if(sectionList[i].getCourseId().equals(id))
				{
					foundSection[i]=sectionList[i];
				}
			}
			
		}

		return foundSection;
	}
	
	public Section[] getAllSection()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/section.txt");
		
		
		Section s=new Section();
		Section[] sectionList=new Section[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				sectionList[i]=s.formSection(str);
				
			}
			
			i++;
		}
		
		return sectionList;
	}
	
	public void write(Section[] sectionList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(sectionList[i]!=null)
			{
				data[i]=sectionList [i].toStringSection();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/section.txt");
	}
}