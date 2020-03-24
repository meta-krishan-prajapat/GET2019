package question3;


/**
 * @author krishan
 * StudentProgramAllocatoris Main class contain main function
 */
public class StudentProgramAllocator {
	public static void main(String list[]) {

		Fetcher fetcher = new Fetcher();
		String programListDestination = "files/Program.xls";
		String studentListDestination = "files/Student.xls";
		fetcher.fetchPrograms(programListDestination);
		fetcher.fetchStudents(studentListDestination);

		ProgramAllocator allocatorObj = new ProgramAllocator();
		try {
			allocatorObj.allocator(fetcher.getPrograms(), fetcher.getStudents(), "files/AllocatedStudent.xls");
			System.out.println("Allocated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}