package seneca.finance;

import btp400.part1.Employee;
import btp400.part2.Programmer;
import btp400.part3.Manager;

public class Payroll {
	private LinkedList employees;
	
	public Payroll(Employee[] employeesToAdd)
	{
		employees = new LinkedList();
		for(int i=0; i < employeesToAdd.length; i++)
		{
			employees.addEmployee(employeesToAdd[i]);
		}
	}
	
	public Payroll()
	{
		employees = new LinkedList();
	}

	public LinkedList getEmployees() {
		return employees;
	}
}
