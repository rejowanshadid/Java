package interfaces;
import java.lang.*;
import entities.*;


public interface IFacultyRepo
{
	void addFaculty(Faculty f);
	void removeFaculty(String key);
	void updateFaculty(Faculty f);
	Faculty searchFacultyByUserId(String id);
	Faculty[] getAllFaculty();
	
}