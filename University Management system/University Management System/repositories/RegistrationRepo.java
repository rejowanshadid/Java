package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class RegistrationRepo implements IRegistrationRepo
{
	public void addRegistration(Registration r)
	{
		Registration[] registrationList=this.getAllRegistration();
		
		for(int i=0;i<registrationList.length;i++)
		{
			if(registrationList[i]==null)
			{
				registrationList[i]=r;
				break;
			}
		}
		
		this.write(registrationList);
	}
	public void removeRegistration(String key)
	{
		Registration[] registrationList=this.getAllRegistration();
		
		for(int i=0;i<registrationList.length;i++)
		{
			if(registrationList[i]!=null)
			{
				if(registrationList[i].getRegistrationId().equals(key))
				{
					registrationList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(registrationList);
	}
	public void updateRegistration(Registration r)
	{
		Registration[] registrationList=this.getAllRegistration();
		
		for(int i=0;i<registrationList.length;i++)
		{
			if(registrationList[i]!=null)
			{
				if(registrationList[i].getRegistrationId().equals(r.getRegistrationId()))
				{
					registrationList[i]=r;
					break;
				}
			}
			
		}
		
		this.write(registrationList);
	}
	
	
	
	public Registration searchRegistrationByRegistrationId(String id)
	{
		Registration[] registrationList=this.getAllRegistration();
		System.out.println("Bro");
		for(int i=0;i<registrationList.length;i++)
		{
			if(registrationList[i]!=null)
			{
				if(registrationList[i].getRegistrationId().equals(id))
				{
					return registrationList[i];
				}
			}
			
		}

		return null;
	}
	
	
	public Registration[] searchRegistrationByUserId(String id)
	{
		Registration[] registrationList=this.getAllRegistration();
		Registration[] foundRegistration=new Registration[100];
		
		for(int i=0;i<registrationList.length;i++)
		{
			if(registrationList[i]!=null)
			{
				if(registrationList[i].getUserId().equals(id))
				{
					foundRegistration[i]=registrationList[i];
				}
			}
			
		}

		return foundRegistration;
	}
	
	public Registration[] searchRegistrationBySemesterId(String id)
	{
		Registration[] registrationList=this.getAllRegistration();
		Registration[] foundRegistration=new Registration[100];
		
		for(int i=0;i<registrationList.length;i++)
		{
			if(registrationList[i]!=null)
			{
				if(registrationList[i].getSemesterId().equals(id))
				{
					foundRegistration[i]=registrationList[i];
				}
			}
			
		}

		return foundRegistration;
	}

	
	public Registration[] getAllRegistration()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/registration.txt");
		
		
		Registration r=new Registration();
		Registration[] registrationList=new Registration[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				registrationList[i]=r.formRegistration(str);
				
			}
			
			i++;
		}
		
		return registrationList;
	}
	
	public void write(Registration[] registrationList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(registrationList[i]!=null)
			{
				data[i]=registrationList [i].toStringRegistration();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/registration.txt");
	}
}