package question3;

/**
 * @author krishan
 * Program class will have list of programs and each program will have its name and its Available Seats in the particular program
 *
 */
public class Program 
{
	private String programName;
	private int availableSeatsInProgram;
	
	/**
	 * @return the name of the program
	 */
	public String getProgramName() {
		return programName;
	}
	
	/**
	 * @param programName is the name of particular program
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	/**
	 * @return the available seats in the program
	 */
	public int getAvailableSeatsInProgram() {
		return availableSeatsInProgram;
	}
	
	/**
	 * @param availableSeatsInProgram sets the capacity of the seats in that particular program
	 */
	public void setAvailableSeatsInProgram(int availableSeatsInProgram) {
		this.availableSeatsInProgram = availableSeatsInProgram;
	}
}