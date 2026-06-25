package interfaces;
import java.lang.*;
import entities.*;


public interface ISemesterRepo
{
	void addSemester(Semester s);
	void removeSemester(String key);
	void updateSemester(Semester s);
	Semester searchSemesterBySemesterId(String id);
	Semester[] getAllSemester();
	
}