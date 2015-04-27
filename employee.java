package btp400.part1;
import java.math.*;

public class Employee {
	
    private String name;
    private String address;
    private double salary;

    public Employee( String n, String e, double s) {

		setName(n);
		setAddress(e);
		setSalary(s);
		
    }

    public Employee() { this(" ", " ", 0.00); };

    public void setName( String name ) 
	{
		this.name = name;
    }
	
	public void setAddress( String address ) 
	{
		this.address = address;
    }
	
	public void setSalary( double salary ) 
	{
		if(salary > 0)
		{
			BigDecimal tmp = new BigDecimal(salary);
			this.salary = tmp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		else
			this.salary = 0.00;
	}
	
	public String getName() { return name; }
	public String getAddress() { return address; }
	public double getSalary() { return salary; }
	
	public double getPay() { return getSalary(); }
	
	public boolean equals( Object c ) {
		boolean result = false;

		if ( c instanceof Employee ) {
			Employee c2 = (Employee) c;

			if( (c2.salary == salary) && (c2.name.equals(name)) && (c2.address.equals(address)) )
				result = true;
		}
		return result;
	}

    public String toString() {

       String s;
       s =    "*****************************************\n" +
              "*           Employee Information        *\n" +
	          "*****************************************\n" +
              "Name: " + name + "\n" +
              "Address: " + address + "\n" +
              "Salary: " + salary + "\n";

       return s;
    }
}
