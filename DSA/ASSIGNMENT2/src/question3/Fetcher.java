package question3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author krishan 
 * Fetcher class provides Methods To fetch the data
 */
public class Fetcher {
	private List<Program> programs;
	private List<Student> students;

	public Fetcher() {
		programs = new ArrayList<Program>();
		students = new ArrayList<Student>();
	}

	/**
	 * @return the list of programs provided by the organisation
	 */
	public List<Program> getPrograms() {
		return programs;
	}

	/**
	 * @param programs add the program to the List Programs
	 */
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	/**
	 * @return the list of added students in the List students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students gets added to the List students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * set programs.xls sheet data into program list
	 * 
	 * @param fileSource string of program.xls
	 * @return list of branches/program
	 */
	public List<Program> fetchPrograms(String fileSource) {
		Workbook workbook = null;
		try {
			if (fileSource == null) {
				throw new Exception("file source cant be null");

			}
			workbook = Workbook.getWorkbook(new File(fileSource));
			Sheet sheet = workbook.getSheet(0);
			Cell cell;
			Program program;
			int rows = sheet.getRows();
			for (int i = 0; i < rows; i++) {
				program = new Program();
				cell = sheet.getCell(0, i);
				program.setProgramName(cell.getContents());
				cell = sheet.getCell(1, i);
				program.setAvailableSeatsInProgram(Integer.parseInt(cell.getContents()));
				programs.add(program);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return programs;
	}

	/**
	 * set student.xls sheet data into program list
	 * 
	 * @param fileSource string of student.xls
	 * @return list of student
	 */
	public List<Student> fetchStudents(String fileSource) {
		Workbook workbook = null;
		try {
			if (fileSource == null) {
				throw new Exception("file source cant be null");

			}
			workbook = Workbook.getWorkbook(new File(fileSource));
			Sheet sheet = workbook.getSheet(0);
			Cell cell;
			Student student;
			int rows = sheet.getRows();
			for (int i = 0; i < rows; i++) {
				student = new Student();
				cell = sheet.getCell(0, i);
				student.setName(cell.getContents());

				cell = sheet.getCell(1, i);
				student.getPrograms().add(cell.getContents());

				cell = sheet.getCell(2, i);
				student.getPrograms().add(cell.getContents());

				cell = sheet.getCell(3, i);
				student.getPrograms().add(cell.getContents());

				cell = sheet.getCell(4, i);
				student.getPrograms().add(cell.getContents());

				cell = sheet.getCell(5, i);
				student.getPrograms().add(cell.getContents());

				students.add(student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return students;
	}
}