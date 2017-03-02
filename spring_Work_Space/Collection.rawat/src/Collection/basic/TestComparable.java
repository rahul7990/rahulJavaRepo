package Collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{

	private String name;
	private int   id;
	
	public Employee(String string, int i) {
		this.name=string;
		this.id=i;
	}

	@Override
	public int compareTo(Employee o) {
		return o.name.compareTo(this.name);
	//	return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
	
}
public class TestComparable {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("Rahul",1);
		Employee emp2 = new Employee("rakesh",5);
		Employee emp3 = new Employee("amit",78);
		Employee emp4 = new Employee("akshay",111);
		Employee emp5= new Employee("narendra",23);
		
		
		List<Employee> list = new ArrayList();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
	
		System.out.println("before sorting:");
		System.out.println(list);
		
		System.out.println("after sorting:");
		Collections.sort(list);
		System.out.println(list);
		
	}
}
