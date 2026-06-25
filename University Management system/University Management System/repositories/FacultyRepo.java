package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class FacultyRepo implements IFacultyRepo
{
	public void addFaculty(Faculty f)
	{
		Faculty[] facultyList=this.getAllFaculty();
		
		for(int i=0;i<facultyList.length;i++)
		{
			if(facultyList[i]==null)
			{
				facultyList[i]=f;
				break;
			}
		}
		
		this.write(facultyList);
	}
	public void removeFaculty(String key)
	{
		Faculty[] facultyList=this.getAllFaculty();
		
		for(int i=0;i<facultyList.length;i++)
		{
			if(facultyList[i]!=null)
			{
				if(facultyList[i].getUserId().equals(key))
				{
					facultyList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(facultyList);
	}
	public void updateFaculty(Faculty f)
	{
		Faculty[] facultyList=this.getAllFaculty();
		
		for(int i=0;i<facultyList.length;i++)
		{
			if(facultyList[i]!=null)
			{
				if(facultyList[i].getUserId().equals(f.getUserId()))
				{
					facultyList[i]=f;
					break;
				}
			}
			
		}
		
		this.write(facultyList);
	}
	public Faculty searchFacultyByUserId(String id)
	{
		Faculty[] facultyList=this.getAllFaculty();
		
		for(int i=0;i<facultyList.length;i++)
		{
			if(facultyList[i]!=null)
			{
				if(facultyList[i].getUserId().equals(id))
				{
					return facultyList[i];
				}
			}
			
		}

		return null;
	}
	public Faculty[] getAllFaculty()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/faculty.txt");
		
		
		Faculty f=new Faculty();
		Faculty[] facultyList=new Faculty[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				facultyList[i]=f.formFaculty(str);
				
			}
			
			i++;
		}
		
		return facultyList;
	}
	
	public void write(Faculty[] facultyList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(facultyList[i]!=null)
			{
				data[i]=facultyList [i].toStringFaculty();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/faculty.txt");
	}
}