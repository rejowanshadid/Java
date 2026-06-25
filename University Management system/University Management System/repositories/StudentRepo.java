package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class StudentRepo implements IStudentRepo
{
	public void addStudent(Student s)
	{
		Student[] studentList=this.getAllStudent();
		
		for(int i=0;i<studentList.length;i++)
		{
			if(studentList[i]==null)
			{
				studentList[i]=s;
				break;
			}
		}
		
		this.write(studentList);
	}
	public void removeStudent(String key)
	{
		Student[] studentList=this.getAllStudent();
		
		for(int i=0;i<studentList.length;i++)
		{
			if(studentList[i]!=null)
			{
				if(studentList[i].getUserId().equals(key))
				{
					studentList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(studentList);
	}
	public void updateStudent(Student s)
	{
		Student[] studentList=this.getAllStudent();
		
		for(int i=0;i<studentList.length;i++)
		{
			if(studentList[i]!=null)
			{
				if(studentList[i].getUserId().equals(s.getUserId()))
				{
					studentList[i]=s;
					break;
				}
			}
			
		}
		
		this.write(studentList);
	}
	public Student searchStudentByUserId(String id)
	{
		Student[] studentList=this.getAllStudent();
		
		for(int i=0;i<studentList.length;i++)
		{
			if(studentList[i]!=null)
			{
				if(studentList[i].getUserId().equals(id))
				{
					return studentList[i];
				}
			}
			
		}

		return null;
	}
	public Student[] getAllStudent()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/student.txt");
		
		
		Student s=new Student();
		Student[] studentList=new Student[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				studentList[i]=s.formStudent(str);
				
			}
			
			i++;
		}
		
		return studentList;
	}
	
	public void write(Student[] studentList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(studentList[i]!=null)
			{
				data[i]=studentList [i].toStringStudent();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/student.txt");
	}
}