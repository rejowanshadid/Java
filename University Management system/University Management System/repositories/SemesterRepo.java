package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class SemesterRepo implements ISemesterRepo
{
	public void addSemester(Semester s)
	{
		Semester[] semesterList=this.getAllSemester();
		
		for(int i=0;i<semesterList.length;i++)
		{
			if(semesterList[i]==null)
			{
				semesterList[i]=s;
				break;
			}
		}
		
		this.write(semesterList);
	}
	public void removeSemester(String key)
	{
		Semester[] semesterList=this.getAllSemester();
		
		for(int i=0;i<semesterList.length;i++)
		{
			if(semesterList[i]!=null)
			{
				if(semesterList[i].getSemesterId().equals(key))
				{
					semesterList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(semesterList);
	}
	public void updateSemester(Semester s)
	{
		Semester[] semesterList=this.getAllSemester();
		
		for(int i=0;i<semesterList.length;i++)
		{
			if(semesterList[i]!=null)
			{
				if(semesterList[i].getSemesterId().equals(s.getSemesterId()))
				{
					semesterList[i]=s;
					break;
				}
			}
			
		}
		
		this.write(semesterList);
	}
	public Semester searchSemesterBySemesterId(String id)
	{
		Semester[] semesterList=this.getAllSemester();
		
		for(int i=0;i<semesterList.length;i++)
		{
			if(semesterList[i]!=null)
			{
				if(semesterList[i].getSemesterId().equals(id))
				{
					return semesterList[i];
				}
			}
			
		}

		return null;
	}
	public Semester[] getAllSemester()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/semester.txt");
		
		
		Semester s=new Semester();
		Semester[] semesterList=new Semester[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				semesterList[i]=s.formSemester(str);
				
			}
			
			i++;
		}
		
		return semesterList;
	}
	
	public void write(Semester[] semesterList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(semesterList[i]!=null)
			{
				data[i]=semesterList [i].toStringSemester();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/semester.txt");
	}
}