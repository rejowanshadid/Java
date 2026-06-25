package interfaces;
import java.lang.*;
import entities.*;


public interface ICourseRepo
{
	void addCourse(Course c);
	void removeCourse(String key);
	void updateCourse(Course c);
	Course searchCourseByCourseId(String id);
	Course[] searchCourseByDepartmentId(String id);
	Course[] getAllCourse();
	
}