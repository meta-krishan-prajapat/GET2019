package assignment3;

/**
 * @author krishan
 * Marksheet class calculates the average, maximum grade,minimum grade and percentage.
 */
public class Marksheet {

	/**
	 * method calculates the average of the grades of n no. of students.
	 * @param noOfStudents,assumes noOfStudents>0
	 * @param grades an array of the grades of each student, assumes grade>=0.00 and grade<=100.00
	 * @return average of grades
	 */
	public double average(int noOfStudents, double[] grades) {
		double sum = 0, average = 0;
		try {
			for (int i = 0; i < noOfStudents; i++)
				if (grades[i] >= 0.00 && grades[i] <= 100.00) {
					sum += grades[i];
					average = sum / noOfStudents;
				} else {
					throw (new Exception("grades should be greater than 0.00 and less than 100.00"));
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return average;
	}

	/**
	 * method calculates the maximum of all grades
	 * @param noOfStudents,assumes noOfStudents>0
	 * @param grades an array of the grades of each student, assumes grade>=0.00 and grade<=100.00
	 * @return maximum grade
	 */
	public double maxGrade(int noOfStudents, double[] grades) throws ArithmeticException {
		double max = 0;
		try {
			max = grades[0];
			for (int i = 1; i < noOfStudents; i++) {
				if (grades[i] >= 0.00 && grades[i] <= 100.00) {
					if (grades[i] > max)
						max = grades[i];
				} else {
					throw (new Exception("grades should be greater than 0.00 and less than 100.00"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return max;
	}

	/**
	 * method calculates the minimum of all grades 
	 * @param noOfStudents,assumes noOfStudents>0
	 * @param grades an array of the grades of each student, assumes grade>=0.00 and grade<=100.00
	 * @return minimum grade
	 */
	public double minGrade(int noOfStudents, double[] grades) {
		double min = 0;
		try {
			min = grades[0];
			for (int i = 1; i < noOfStudents; i++) {
				if (grades[i] >= 0.00 && grades[i] <= 100.00) {
					if (grades[i] < min)
						min = grades[i];
				} else {
					throw (new Exception("grades should be greater than 0.00 and less than 100.00"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return min;
	}

	/**
	 * method calculates the percentage of students passed, student is passed if grade >=40
	 * @param noOfStudents,assumes noOfStudents>0
	 * @param grades an array of the grades of each student, assumes grade>=0.00 and grade<=100.00
	 * @return percentage of students passed
	 */
	public double studentsPassedPercent(int noOfStudents, double[] grades) {
		double pass = 0, studentsPassedPercent = 0;
		try {
			for (int i = 0; i < noOfStudents; i++) {
				if (grades[i] >= 0.00 && grades[i] <= 100.00) {
					if (grades[i] >= 40)
						pass++;
					studentsPassedPercent = (pass / noOfStudents) * 100;
				} else {
					throw (new Exception("grades should be greater than 0.00 and less than 100.00"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentsPassedPercent;
	}

}