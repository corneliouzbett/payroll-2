package btp400.part3;
import java.util.*;
import java.math.*;

import btp400.part1.Employee;
import btp400.part2.Programmer;

public class Manager extends Employee {

	private ArrayList<Programmer> employees;
	private double bonus;
	
	public Manager( String n, String e, double s, double b )
	{
		super( n, e, s);
		if(b>0)
			this.bonus = b;
		else
			this.bonus = 0.00;
		employees = new ArrayList<Programmer>();
	}
	
	public Manager()
	{
		super();
		bonus = 0.00;
		employees = new ArrayList<Programmer>();
	}

	public boolean supervise( Programmer pgr )
	{
		if(pgr != null)
		{
			for (int i = 0; i<employees.size(); i++)
			{
				if (pgr.equals(employees.get(i)))
					return false;
			}
			employees.add(pgr);
			return true;
		}
		else
			return false;
	}
	
	public double getBaseBonus()
	{
		BigDecimal tmp = new BigDecimal(bonus);
		bonus = tmp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return bonus;
	}
	
	public double getBonusPay()
	{
		double  bonusPay;
		int count = 0;
		for (int i = 0; i<employees.size(); i++)
			{
				if (employees.get(i).getOvertimePay() > 0)
					count++;
			}
		if (count < 100)
			bonusPay = bonus * (1 - 0.01 * count);
		else 
			bonusPay = 0;
		BigDecimal tmp = new BigDecimal(bonusPay);
		bonusPay = tmp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return bonusPay;
	}
	
	public double getPay( )
	{
		return super.getPay() + getBonusPay();
	}

	public String toString() 
	{
		String s;
		s = super.toString() + "Bonus: " + getBaseBonus() + "\n\nSupervising: \n";
		for (int i=0; i < employees.size(); i++)
			s += "Name: " + employees.get(i).getName() + "\n";
		return s;
	}
	
	public boolean equals( Object c )
	{
		if ( c instanceof Manager ) {
			Manager c2 = (Manager) c;
			if((c2.getSalary() == getSalary()) && (c2.getName().equals(getName())) && (c2.getAddress().equals(getAddress())) && this.employees.containsAll(c2.employees) && c2.employees.containsAll(this.employees))
				return true;
		}
		return false;
	}
}
