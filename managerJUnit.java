package btp400.part3;

import static org.junit.Assert.*;

import org.junit.Test;

import btp400.part2.Programmer;

public class ManagerTest {

	@Test
	public void testManager()
	{
		Manager man = new Manager(null, null, 4444.45678, 500.2389);
		Manager man2 = new Manager(null, null, -4444.46, -500.24);
		Manager man3 = new Manager();
		Manager man4 = new Manager();
		Programmer pro = new Programmer("John", "john@x.com", 3333.45678);
		Programmer pro2 = new Programmer("Sam", "sam@x.com", 3333.45678);
		
		//1. Test if the Manager object has been initialized correctly
		assertEquals(null, man.getName());
		assertEquals(null, man.getAddress());
		assertEquals(4444.46, man.getSalary(), 0);
		assertEquals(500.24, man.getBaseBonus(), 0);
		
		//2. Test if the Manager object has been initialized correctly
		assertEquals(0, man2.getSalary(), 0);
		assertEquals(0, man2.getBaseBonus(), 0);
		
		//3. Test if the default constructor has initialized the Manager object correctly
		assertEquals(" ", man3.getName());
		assertEquals(" ", man3.getAddress());
		assertEquals(0, man3.getSalary(), 0);
		assertEquals(0, man2.getBaseBonus(), 0);
		
		//4. Test if the equals method is working correctly (no supervision)
		boolean result1 = man3.equals(man4);
		assertEquals(true, result1);
		result1 = man.equals(man4);
		assertEquals(false, result1);
		
		//6. Test if the toString method will return identical strings for two Employee objects that have the same data contents
		assertEquals(man3.toString(), man4.toString());
		
		//7. Test if the supervise method works correctly for the following cases: 
			//A. null reference 
			boolean result2 = man3.supervise(null);
			assertEquals(false, result2);
			//B. duplicates (i.e. the programmer is already under supervision)
			boolean result3 = man3.supervise(pro);
			boolean result4 = man3.supervise(pro);
			assertEquals(true, result3);
			assertEquals(false, result4);
			//C. a new programmer 
			boolean result5 = man3.supervise(pro2);
			assertEquals(true, result5);
		
		//4. Test if the equals method is working correctly (with supervision)
		man4.supervise(pro);
		man4.supervise(pro2);
		boolean result6 = man3.equals(man4);
		assertEquals(true, result6);
		result6 = man.equals(man4);
		assertEquals(false, result6);
	}

}
