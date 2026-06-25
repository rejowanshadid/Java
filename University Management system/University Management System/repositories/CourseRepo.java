package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class CourseRepo implements ICourseRepo
{
	public void addCourse(Course c)
	{
		Course[] courseList=this.getAllCourse();
		
		for(int i=0;i<courseList.length;i++)
		{
			if(courseList[i]==null)
			{
				courseList[i]=c;
				break;
			}
		}
		
		this.write(courseList);
	}
	public void removeCourse(String key)
	{
		Course[] courseList=this.getAllCourse();
		
		for(int i=0;i<courseList.length;i++)
		{
			if(courseList[i]!=null)
			{
				if(courseList[i].getCourseId().equals(key))
				{
					courseList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(courseList);
	}
	public void updateCourse(Course c)
	{
		Course[] courseList=this.getAllCourse();
		
		for(int i=0;i<courseList.length;i++)
		{
			if(courseList[i]!=null)
			{
				if(courseList[i].getCourseId().equals(c.getCourseId()))
				{
					courseList[i]=c;
					break;
				}
			}
			
		}
		
		this.write(courseList);
	}
	public Course searchCourseByCourseId(String id)
	{
		Course[] courseList=this.getAllCourse();
		
		for(int i=0;i<courseList.length;i++)
		{
			if(courseList[i]!=null)
			{
				if(courseList[i].getCourseId().equals(id))
				{
					return courseList[i];
				}
			}
			
		}

		return null;
	}
	
	public Course[] searchCourseByDepartmentId(String id)
	{
		Course[] courseList=this.getAllCourse();
		Course[] foundCourse=new Course[100];
		
		for(int i=0;i<courseList.length;i++)
		{
			if(courseList[i]!=null)
			{
				if(courseList[i].getDepartmentId().equals(id))
				{
					foundCourse[i]=courseList[i];
				}
			}
			
		}

		return foundCourse;
	}
	public Course[] getAllCourse()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/course.txt");
		
		
		Course c=new Course();
		Course[] courseList=new Course[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				courseList[i]=c.formCourse(str);
				
			}
			
			i++;
		}
		
		return courseList;
	}
	
	public void write(Course[] courseList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(courseList[i]!=null)
			{
				data[i]=courseList [i].toStringCourse();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/course.txt");
	}
}