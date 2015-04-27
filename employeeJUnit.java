package btp400.part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testEmployee() {
		Employee emp = new Employee (null, null, 123.45678);
		Employee emp2 = new Employee (null, null, -123.45);
		Employee emp3 = new Employee();
		Employee emp4 = new Employee();
		
		//1. Test if the Employee object has been initialized correctly
		assertEquals(null, emp.getName());
		assertEquals(null, emp.getAddress());
		assertEquals(123.46, emp.getSalary(), 0);
		
		//2. Test if the Employee object has been initialized correctly
		assertEquals(0, emp2.getSalary(), 0);
		
		//3. Test if the default constructor has initialized the Employee object correctly
		assertEquals(" ", emp3.getName());
		assertEquals(" ", emp3.getAddress());
		assertEquals(0, emp3.getSalary(), 0);
		
		//4. Test if the getSalary and getPay methods are working correctly
		double result1 = emp.getSalary();
		double result2 = emp.getPay();
		assertEquals(123.46, result1, 0);
		assertEquals(123.46, result2, 0);
		
		//5. Test if the equals method is working correctly
		boolean result3 = emp.equals(emp2);
		boolean result4 = emp3.equals(emp4);
		assertEquals(false, result3);
		assertEquals(true, result4);
		
		//6. Test if the toString method will return identical strings for two Employee objects that have the same data contents
		assertEquals(emp3.toString(), emp4.toString());
	}

}
