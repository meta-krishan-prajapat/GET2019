package question1_b;

import org.junit.Test;

/**
 * @author krishan
 * test class for EmployeeOperations class 
 *
 */
public class EmployeeTest {
	/**
	 * add the employee and sorted the list on the basis of the name
	 */
	@Test
	public void testSortByName() {EmployeeOperations ep = new EmployeeOperations();
	ep.addEmployee(new Employee(1, "krishan", "churu"));
	ep.addEmployee(new Employee(5, "vinod", "Udaipur"));
	ep.addEmployee(new Employee(3, "priya", "jaipur"));
	ep.addEmployee(new Employee(4, "ali", "jhalawad"));
	
	ep.sortEmployeeByName();
	ep.printList();
	}

}