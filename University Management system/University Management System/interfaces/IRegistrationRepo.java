package interfaces;
import java.lang.*;
import entities.*;


public interface IRegistrationRepo
{
	void addRegistration(Registration r);
	void removeRegistration(String key);
	void updateRegistration(Registration r);
	Registration searchRegistrationByRegistrationId(String id);
	Registration[] searchRegistrationByUserId(String id);
	Registration[] searchRegistrationBySemesterId(String id);
	Registration[] getAllRegistration();
	
}