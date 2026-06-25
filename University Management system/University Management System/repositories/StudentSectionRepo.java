package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class StudentSectionRepo implements IStudentSectionRepo
{
	public void addStudentSection(StudentSection s)
	{
		StudentSection[] studentSectionList=this.getAllStudentSection();
		
		for(int i=0;i<studentSectionList.length;i++)
		{
			if(studentSectionList[i]==null)
			{
				studentSectionList[i]=s;
				break;
			}
		}
		
		this.write(studentSectionList);
	}
	public void removeStudentSection(String key)
	{
		StudentSection[] studentSectionList=this.getAllStudentSection();
		
		for(int i=0;i<studentSectionList.length;i++)
		{
			if(studentSectionList[i]!=null)
			{
				if(studentSectionList[i].getStudentSectionId().equals(key))
				{
					studentSectionList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(studentSectionList);
	}
	public void updateStudentSection(StudentSection s)
	{
		StudentSection[] studentSectionList=this.getAllStudentSection();
		
		for(int i=0;i<studentSectionList.length;i++)
		{
			if(studentSectionList[i]!=null)
			{
				if(studentSectionList[i].getStudentSectionId().equals(s.getStudentSectionId()))
				{
					studentSectionList[i]=s;
					break;
				}
			}
			
		}
		
		this.write(studentSectionList);
	}
	
	
	
	public StudentSection searchStudentSectionByStudentSectionId(String id)
	{
		StudentSection[] studentSectionList=this.getAllStudentSection();
		
		for(int i=0;i<studentSectionList.length;i++)
		{
			if(studentSectionList[i]!=null)
			{
				if(studentSectionList[i].getStudentSectionId().equals(id))
				{
					return studentSectionList[i];
				}
			}
			
		}

		return null;
	}
	
	public StudentSection[] searchStudentSectionBySectionId(String id)
	{
		StudentSection[] studentSectionList=this.getAllStudentSection();
		StudentSection[] foundStudentSection=new StudentSection[100];
		
		for(int i=0;i<studentSectionList.length;i++)
		{
			if(studentSectionList[i]!=null)
			{
				if(studentSectionList[i].getSectionId().equals(id))
				{
					foundStudentSection[i]=studentSectionList[i];
				}
			}
			
		}

		return foundStudentSection;
	}
	
	public StudentSection[] searchStudentSectionByUserId(String id)
	{
		StudentSection[] studentSectionList=this.getAllStudentSection();
		StudentSection[] foundStudentSection=new StudentSection[100];
		
		for(int i=0;i<studentSectionList.length;i++)
		{
			if(studentSectionList[i]!=null)
			{
				if(studentSectionList[i].getUserId().equals(id))
				{
					foundStudentSection[i]=studentSectionList[i];
				}
			}
			
		}

		return foundStudentSection;
	}
	

	
	public StudentSection[] getAllStudentSection()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/studentSection.txt");
		
		
		StudentSection s=new StudentSection();
		StudentSection[] studentSectionList=new StudentSection[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				studentSectionList[i]=s.formStudentSection(str);
				
			}
			
			i++;
		}
		
		return studentSectionList;
	}
	
	public void write(StudentSection[] studentSectionList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(studentSectionList[i]!=null)
			{
				data[i]=studentSectionList [i].toStringStudentSection();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/studentSection.txt");
	}
}