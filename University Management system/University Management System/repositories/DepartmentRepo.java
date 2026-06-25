package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class DepartmentRepo implements IDepartmentRepo
{
	public void addDepartment(Department d)
	{
		Department[] departmentList=this.getAllDepartment();
		
		for(int i=0;i<departmentList.length;i++)
		{
			if(departmentList[i]==null)
			{
				departmentList[i]=d;
				break;
			}
		}
		
		this.write(departmentList);
	}
	public void removeDepartment(String key)
	{
		Department[] departmentList=this.getAllDepartment();
		
		for(int i=0;i<departmentList.length;i++)
		{
			if(departmentList[i]!=null)
			{
				if(departmentList[i].getDepartmentId().equals(key))
				{
					departmentList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(departmentList);
	}
	public void updateDepartment(Department d)
	{
		Department[] departmentList=this.getAllDepartment();
		
		for(int i=0;i<departmentList.length;i++)
		{
			if(departmentList[i]!=null)
			{
				if(departmentList[i].getDepartmentId().equals(d.getDepartmentId()))
				{
					departmentList[i]=d;
					break;
				}
			}
			
		}
		
		this.write(departmentList);
	}
	public Department searchDepartmentByDepartmentId(String id)
	{
		Department[] departmentList=this.getAllDepartment();
		
		for(int i=0;i<departmentList.length;i++)
		{
			if(departmentList[i]!=null)
			{
				if(departmentList[i].getDepartmentId().equals(id))
				{
					return departmentList[i];
				}
			}
			
		}

		return null;
	}
	public Department[] getAllDepartment()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/department.txt");
		
		
		Department d=new Department();
		Department[] departmentList=new Department[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				departmentList[i]=d.formDepartment(str);
				
			}
			
			i++;
		}
		
		return departmentList;
	}
	
	public void write(Department[] departmentList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(departmentList[i]!=null)
			{
				data[i]=departmentList [i].toStringDepartment();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/department.txt");
	}
}