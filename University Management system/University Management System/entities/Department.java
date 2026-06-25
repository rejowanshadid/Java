package entities;
import java.lang.*;

public class Department
{
	private String departmentId, departmentName;
	
	public Department()
	{
	}
	
	public Department(String departmentId,String departmentName)
	{
		this.departmentId=departmentId;
		this.departmentName=departmentName;
	}
	
	public void setDepartmentId(String departmentId)
	{
		this.departmentId=departmentId;
	}
	
	public void setDepartmentName(String departmentName)
	{
		this.departmentName=departmentName;
	}
	
	public String getDepartmentId()
	{
		return this.departmentId;
	}
	
	public String getDepartmentName()
	{
		return this.departmentName;
	}
	
	public String toStringDepartment()
	{
		String str=this.departmentId+","+this.departmentName+"\n";
		return str;
	}
	
	public Department formDepartment(String str)
	{
		String[] info=str.split(",");
		Department d=new Department();
		d.setDepartmentId(info[0]);
		d.setDepartmentName(info[1]);
		return d;
	}
}