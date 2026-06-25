package interfaces;
import java.lang.*;
import entities.*;


public interface IDepartmentRepo
{
	void addDepartment(Department d);
	void removeDepartment(String key);
	void updateDepartment(Department d);
	Department searchDepartmentByDepartmentId(String id);
	Department[] getAllDepartment();
	
}