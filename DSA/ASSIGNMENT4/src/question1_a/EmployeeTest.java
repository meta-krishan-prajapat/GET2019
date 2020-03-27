package question1_a;
import org.junit.Test;

/**
 * @author krishan
 * test class for EmployeeOperations class 
 *
 */
public class EmployeeTest {
	/**
	 * add the employee and sorted the list on the basis of the Id
	 */
	@Test
	public void test() {
		EmployeeOperations ep = new EmployeeOperations();
	ep.addEmployee(new Employee(1, "krishan", "churu"));
	ep.addEmployee(new Employee(5, "vinod", "Udaipur"));
	ep.addEmployee(new Employee(3, "ali", "jhalawad"));
	ep.addEmployee(new Employee(4, "jyoti", "jaipur"));
	ep.addEmployee(new Employee(2, "naman", "Jaipur"));
	ep.sortedList();
	ep.printList();
	}

}