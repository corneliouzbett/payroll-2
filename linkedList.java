package seneca.finance;

import btp400.part1.Employee;
import btp400.part2.Programmer;
import btp400.part3.Manager;

class Link 
{
    public Employee employeeData;
    public Link nextLink;

    //Link constructor
    public Link(Employee employee) 
	{
	    employeeData = employee;
    }
	
	public String printLink() 
	{
		String suffix = "";
		if(employeeData instanceof Programmer)
		{
			Programmer c2 = (Programmer)employeeData;
			if(c2.getOvertimePay() > 0)
				suffix = " OVTP";
		}
		else if(employeeData instanceof Manager)
			suffix = " MNGR";
		System.out.print("Name: " + employeeData.getName() + "\n" + "Total: $" + employeeData.getPay() + suffix + "\n");
		return null;
    }
}

public class LinkedList 
{
    private Link first;
	private int count;

    //LinkList constructor
    public LinkedList() 
	{
	    first = null;
    }
	
	public int size()
	{
		return count;
	}

    //Inserts a new Link at the first of the list
    public boolean addEmployee(Employee employee)
	{
	    Link link = new Link(employee);
	    link.nextLink = first;
	    first = link;
		count++;
		return true;
    }
    
    public Employee removeEmployee(String employeeName, String emailAddress)
    {
	    Link currentLink = first;
		Link previous = null;

        if (first.employeeData.getName().equals(employeeName) && first.employeeData.getAddress().equals(emailAddress)) 
        {
        	first = first.nextLink;
        	count--;
            return first.employeeData;
        }

        while (currentLink != null && currentLink.employeeData.getName() != employeeName && first.employeeData.getAddress() != emailAddress) 
        {
        	previous = currentLink;
        	currentLink = currentLink.nextLink;
        }

        if (currentLink == null) 
        {
            System.out.println("A node with that value does not exist.");
            return first.employeeData;
        }
        else 
        {
        	previous.nextLink = currentLink.nextLink;
        }
        count--;
        return first.employeeData;

    }

    //Prints list data
	public String toString()
	{
	    Link currentLink = first;
		System.out.println("");
	    while(currentLink != null) 
		{
		    currentLink.printLink();
		    currentLink = currentLink.nextLink;
	    }
	    System.out.println("");
		return null;
    }
}
