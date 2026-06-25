package interfaces;
import java.lang.*;
import entities.*;


public interface IStudentRepo
{
	void addStudent(Student s);
	void removeStudent(String key);
	void updateStudent(Student s);
	Student searchStudentByUserId(String id);
	Student[] getAllStudent();
	
}