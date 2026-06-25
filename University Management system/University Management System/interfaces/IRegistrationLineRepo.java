package interfaces;
import java.lang.*;
import entities.*;

public interface IRegistrationLineRepo
{
	 void addRegistrationLine(RegistrationLine rl);
	 void removeRegistrationLine(String key);
	 void updateRegistrationLine(RegistrationLine rl);
	 RegistrationLine searchRegistrationLineByRegistrationLineId(String registrationLineId);
	 RegistrationLine[] searchRegistrationLineByRegistrationId(String registrationId);
	 RegistrationLine[] searchRegistrationLineBySectionId(String sectionId);
	 RegistrationLine[] getAllRegistrationLine();
	 
	
}