package seneca.finance;

import static org.junit.Assert.*;

import org.junit.Test;

import btp400.part1.Employee;
import btp400.part2.Programmer;
import btp400.part3.Manager;

public class PayrollTest {

	@Test
	public void testPayroll() {
        
        Programmer pro1 = new Programmer("Artemy", "gmail", 3333.45678);
        pro1.setOvertimePay(100.23);
        Manager pro2 = new Manager("Bob", "hotmail", -123.453, 500.233);
		Programmer pro3 = new Programmer("Casey", "yahoo" , 0); 
		Manager pro4 = new Manager("Donald", "modem", 123.45678, 200.4555);
		Programmer pro5 = new Programmer("Ellen", "myseneca", 123.45678);
		
		//1. Test constructor with no parameter
		Payroll payrollTest = new Payroll();
		
		//2. Test constructor with parameter
		Employee[] list = {pro1, pro2, pro3, pro4, pro5};
		Payroll payrollTest2 = new Payroll(list);
		Employee result = payrollTest2.employees.removeEmployee(pro5.getName(), pro5.getAddress());
		assertEquals("Donald", result.getName());
		
		//3. Test addEmployee() method and size() method
		boolean result1 = payrollTest.employees.addEmployee(pro1);
		assertEquals(1, payrollTest.employees.size());
		boolean result2 = payrollTest.employees.addEmployee(pro2);
		boolean result3 = payrollTest.employees.addEmployee(pro3);
		boolean result4 = payrollTest.employees.addEmployee(pro4);
		boolean result5 = payrollTest.employees.addEmployee(pro5);
		assertEquals(5, payrollTest.employees.size());
		assertEquals(true, result1);
		assertEquals(true, result2);
		assertEquals(true, result3);
		assertEquals(true, result4);
		assertEquals(true, result5);
		
		//4. Test removeEmployee() method and size() method
		Employee result6 = payrollTest.employees.removeEmployee(pro5.getName(), pro5.getAddress());
		assertEquals(4, payrollTest.employees.size());
		Employee result7 = payrollTest.employees.removeEmployee(pro4.getName(), pro4.getAddress());
		assertEquals("Donald", result6.getName());
		assertEquals("Casey", result7.getName());
	}

}
