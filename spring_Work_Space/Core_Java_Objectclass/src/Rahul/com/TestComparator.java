package Rahul.com;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable
{
	int id;
	String name;
	
	Employee(int id, String name)
	{
		this.id=id;
		this.name=name;
		
	}

	public String toString()
	{
		return "id="+id+",name="+name;
	}

	@Override
	public int compareTo(Object o) {
//		Employee E = (Employee)o;
		return this.name.compareTo(((Employee)o).name);
		
		//if want to print in reverse order then use "-"
	}
}


class E implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		
		Employee E1 = (Employee)o1;
		Employee E2 = (Employee)o2;
		return E1.id - E2.id;
	}
  
}

class H implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		
		Employee E1 = (Employee)o1;
		Employee E2 = (Employee)o2;
		return E1.name.compareTo(E2.name);
	}
  
}

public class TestComparator {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1, "rahul");
		Employee e2 = new Employee(3, "akshey");
		Employee e3 = new Employee(167, "amit");
		Employee e4 = new Employee(1108, "narendra");
		
		List listofEmployee = new ArrayList();
		
		listofEmployee.add(e1);
		listofEmployee.add(e2);
		listofEmployee.add(e3);
		listofEmployee.add(e4);
		
		System.out.println(listofEmployee);
//		Collections.sort(listofEmployee, new H());
		Collections.sort(listofEmployee);
		System.out.println(listofEmployee);
	}

}
