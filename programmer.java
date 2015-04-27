package btp400.part2;

import btp400.part1.Employee;

public class Programmer extends Employee{
	
	private double overtimePay;
	
	public Programmer( String n, String e, double s){
		super( n, e, s);
		overtimePay = 0;
	}
	
	public Programmer()
	{
		super();
		overtimePay = 0.00;
	}
	
	public boolean addOvertimePay( double ot )
	{
		if( ot > super.getSalary() / 2 || ot < 0)
			return false;
		else
		{
			this.overtimePay += ot;
			return true;
		}
	}
    
	public boolean setOvertimePay( double newOvertimePay)
	{
		if( newOvertimePay > super.getSalary() / 2  || newOvertimePay < 0)
			return false;
		else
		{
			this.overtimePay = newOvertimePay;
			return true;
		}
	}
	
    public double getOvertimePay( )
	{
		return overtimePay;
	}
    
	public double getPay( )
	{
		return super.getPay() + getOvertimePay();
	}
	
    public String toString()
	{
		String s;
		s = super.toString() + "Overtime Pay: " + overtimePay + "\n";
		return s;
	}

	public boolean equals( Object c ) {
		boolean result = false;

		if ( c instanceof Programmer ) {
			Programmer c2 = (Programmer) c;

			if( (c2.getSalary() == getSalary()) && (c2.getOvertimePay() == getOvertimePay()) && (c2.getName().equals(getName())) && (c2.getAddress().equals(getAddress())) )
				result = true;
		}
		return result;
	}
}
