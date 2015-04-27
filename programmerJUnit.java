package btp400.part2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProgrammerTest {

	@Test
	public void testProgrammer() {
		
		Programmer pro = new Programmer(null, null, 3333.45678);
		Programmer pro2 = new Programmer(null, null, -123.45);
		Programmer pro3 = new Programmer();
		Programmer pro4 = new Programmer();
		
		//1. Test if the Programmer object has been initialized correctly
		assertEquals(null, pro.getName());
		assertEquals(null, pro.getAddress());
		assertEquals(3333.46, pro.getSalary(), 0);
		
		//2. Test if the Programmer object has been initialized correctly
		assertEquals(0, pro2.getSalary(), 0);
		
		//3. Test if the default constructor has initialized the Programmer object correctly
		assertEquals(" ", pro3.getName());
		assertEquals(" ", pro3.getAddress());
		assertEquals(0, pro3.getSalary(), 0);
		
		//4. Test if the equals method is working correctly
		boolean result1 = pro.equals(pro2);
		boolean result2 = pro3.equals(pro4);
		assertEquals(false, result1);
		assertEquals(true, result2);
		
		//5. Test if all the setters are working correctly
		boolean result5 = pro.setOvertimePay(pro.getSalary()/2);
		boolean result6 = pro.addOvertimePay(pro.getSalary()/2);
		assertEquals(true, result5);
		assertEquals(true, result6);
		
		//6. Test if the toString method will return identical strings for two Programmer objects that have same data contents
		assertEquals(pro3.toString(), pro4.toString());
		
		//7. Test if the addOvertimePay and setOvertimePay methods work correctly with negative values
		boolean result7 = pro.setOvertimePay(-123.45);
		boolean result8 = pro.addOvertimePay(-123.45);
		assertEquals(false, result7);
		assertEquals(false, result8);
		
		//8. Test if the addOvertimePay and setOvertimePay methods work correctly when the invocations attempt to exceed the maximum amount of overtime pay
		boolean result3 = pro.setOvertimePay(pro.getSalary());
		boolean result4 = pro.addOvertimePay(pro.getSalary());
		assertEquals(false, result3);
		assertEquals(false, result4);

	}

}
