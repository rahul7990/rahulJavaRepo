package Collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	
	String name;
	int rollNo;
	
    class nameComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			
			return o1.name.compareTo(o2.name);
		}
		
	}
	
	static class rollNoComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			String str1 = String.valueOf(o1.rollNo);
			String str2 = String.valueOf(o2.rollNo);
			return str1.compareTo(str2);
		}
		
	}
	public Student() {
		
	}

	public Student(String string, int i) {
		this.name = string;
		this.rollNo = i;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
	
	
}


public class TestComparatorInnerClass {

	public static void main(String[] args) {
		
		Student stu1 = new Student("Rahul",1);
		Student stu2 = new Student("narendra",6);
		Student stu3 = new Student("aman",3);
		Student stu4 = new Student("Bijoy",90);
		Student stu5 = new Student("Sumit",11);
		Student stu6 = new Student("Ram",44);
		
		List<Student> list = new ArrayList();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		list.add(stu6);
		
		System.out.println("Sorting based on name:");
		Collections.sort(list, new Student().new nameComparator());
		System.out.println(list);
		System.out.println("Sorting based on rollNo:");
		Collections.sort(list, new Student.rollNoComparator());
		System.out.println(list);
	}
}
