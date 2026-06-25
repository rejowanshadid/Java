package interfaces;
import java.lang.*;
import entities.*;


public interface ISectionRepo
{
	void addSection(Section s);
	void removeSection(String key);
	void updateSection(Section s);
	Section searchSectionBySectionId(String id);
	Section[] searchSectionByUserId(String id);
	Section[] searchSectionBySemesterId(String id);
	Section[] searchSectionByCourseId(String id);
	Section[] getAllSection();
	
}