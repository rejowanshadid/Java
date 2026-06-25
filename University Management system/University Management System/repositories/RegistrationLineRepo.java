package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class RegistrationLineRepo implements IRegistrationLineRepo
{
	public void addRegistrationLine(RegistrationLine rl)
	{
		RegistrationLine[] registrationLineList=this.getAllRegistrationLine();
		
		for(int i=0;i<registrationLineList.length;i++)
		{
			if(registrationLineList[i]==null)
			{
				registrationLineList[i]=rl;
				break;
			}
		}
		
		this.write(registrationLineList);
	}
	public void removeRegistrationLine(String key)
	{
		RegistrationLine[] registrationLineList=this.getAllRegistrationLine();
		
		for(int i=0;i<registrationLineList.length;i++)
		{
			if(registrationLineList[i]!=null)
			{
				if(registrationLineList[i].getRegistrationLineId().equals(key))
				{
					registrationLineList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(registrationLineList);
	}
	public void updateRegistrationLine(RegistrationLine rl)
	{
		RegistrationLine[] registrationLineList=this.getAllRegistrationLine();
		
		for(int i=0;i<registrationLineList.length;i++)
		{
			if(registrationLineList[i]!=null)
			{
				if(registrationLineList[i].getRegistrationLineId().equals(rl.getRegistrationLineId()))
				{
					registrationLineList[i]=rl;
					break;
				}
			}
			
		}
		
		this.write(registrationLineList);
	}
	
	
	
	public RegistrationLine searchRegistrationLineByRegistrationLineId(String id)
	{
		RegistrationLine[] registrationLineList=this.getAllRegistrationLine();
		
		for(int i=0;i<registrationLineList.length;i++)
		{
			if(registrationLineList[i]!=null)
			{
				if(registrationLineList[i].getRegistrationLineId().equals(id))
				{
					return registrationLineList[i];
				}
			}
			
		}

		return null;
	}
	
	
	public RegistrationLine[] searchRegistrationLineByRegistrationId(String id)
	{
		RegistrationLine[] registrationLineList=this.getAllRegistrationLine();
		RegistrationLine[] foundRegistrationLine=new RegistrationLine[100];
		
		for(int i=0;i<registrationLineList.length;i++)
		{
			if(registrationLineList[i]!=null)
			{
				if(registrationLineList[i].getRegistrationId().equals(id))
				{
					foundRegistrationLine[i]=registrationLineList[i];
				}
			}
			
		}

		return foundRegistrationLine;
	}
	
	public RegistrationLine[] searchRegistrationLineBySectionId(String id)
	{
		RegistrationLine[] registrationLineList=this.getAllRegistrationLine();
		RegistrationLine[] foundRegistrationLine=new RegistrationLine[100];
		
		for(int i=0;i<registrationLineList.length;i++)
		{
			if(registrationLineList[i]!=null)
			{
				if(registrationLineList[i].getSectionId().equals(id))
				{
					foundRegistrationLine[i]=registrationLineList[i];
				}
			}
			
		}

		return foundRegistrationLine;
	}

	
	public RegistrationLine[] getAllRegistrationLine()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/registrationLine.txt");
		
		
		RegistrationLine rl=new RegistrationLine();
		RegistrationLine[] registrationLineList=new RegistrationLine[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				registrationLineList[i]=rl.formRegistrationLine(str);
				
			}
			
			i++;
		}
		
		return registrationLineList;
	}
	
	public void write(RegistrationLine[] registrationLineList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(registrationLineList[i]!=null)
			{
				data[i]=registrationLineList [i].toStringRegistrationLine();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/registrationLine.txt");
	}
}