package interfaces;
import java.lang.*;
import entities.*;


public interface IStudentSectionRepo
{
	void addStudentSection(StudentSection s);
	void removeStudentSection(String key);
	void updateStudentSection(StudentSection s);
	StudentSection searchStudentSectionByStudentSectionId(String id);
	StudentSection[] searchStudentSectionBySectionId(String id);
	StudentSection[] searchStudentSectionByUserId(String id);
	StudentSection[] getAllStudentSection();
	
}