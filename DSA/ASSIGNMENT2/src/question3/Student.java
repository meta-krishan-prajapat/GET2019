package question3;

import java.util.ArrayList;

/**
 * @author krishan
 * Student class will have name and preference of his programs in descending order
 */
public class Student 
{
	private String studentName;
	private ArrayList<String> programPrecedenceList;
	
	Student()
	{
		programPrecedenceList= new ArrayList<String>();
	}
	
	String getName()
	{
		return studentName;
	}
	
	void setName(String studentName)
	{
		this.studentName = studentName;
	}
	
	/**
	 * @return the list of program precedence in the Excel sheet of user
	 */
	public ArrayList<String> getPrograms() 
	{
		return programPrecedenceList;
	}

	public void setPrograms(ArrayList<String> programs) 
	{
		this.programPrecedenceList = programs;
	}
}
