package question1_c;
import java.util.Comparator;


/**
 * @author krishan
 * Employee class is to keep data of employee
 *
 */
public class Employee implements Comparator {
    int empId;
    String empName;
    String empAddress;
    
    public Employee(int empId, String empName, String empAddress) {
    	
    	try
    	{
    		if(empAddress==null|| empName==null)
    		{
    			throw new Exception("Employee cant be null");
    		}
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getempAddress() {
        return empAddress;
    }
    public void setEmpAdresses(String empAddress) {
        this.empAddress = empAddress;
    }
    //Anonymous class
    public static Comparator<Employee> empid = new Comparator<Employee>() {

        public int compare(Employee s1, Employee s2) {
        	String empName1=null,empName2=null;
        	try
        	{
        		if(s1==null||s2==null)
        		{
        			throw new Exception("Employee cant be null");
        		}
           empName1 = s1.getEmpName();
           empName2 = s2.getEmpName();
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}

           /*For ascending order*/
           return empName1.compareTo(empName2);

       }};

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + "]";
    }
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
       
}