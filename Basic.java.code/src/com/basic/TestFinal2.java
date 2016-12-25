package com.basic;

class Student {
	 
	private String name = null;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
}
public class TestFinal2 {
	public static void main(String[] args) {
		 
		final Student student = new Student();
		student.setName("Prasad");
		System.out.println("name = " + student.getName());
 
		
		student.setName("pranil");
		System.out.println("name = " + student.getName());
	}
}


/*How is this possible? We’ve made the student variable as final, then how is it allowing to change the value?

Well, the actual meaning of final keyword is that you cannot assign a new value to the variable once you have assigned a value. Let us compare with previous example.


final int someNumber = 0;
someNumber = 10; // This does not compile
1
2
final int someNumber = 0;
someNumber = 10; // This does not compile
here we are trying to assign 10 even after assigning value 0 to someNumber previously. Thats why it does not compile.

 

In our second example,


final Student student = new Student();
student.setName("Prasad");
System.out.println("name = " + student.getName());
student.setName("pranil");
System.out.println("name = " + student.getName());

final Student student = new Student();
student.setName("Prasad");
System.out.println("name = " + student.getName());
student.setName("pranil");
System.out.println("name = " + student.getName());*/
/* We created a Student object which is referred by reference variable student
 We set the name for Student object as “ prasad “.
 Then printed the name of Student
 Again set the name for Student as “ pranil “.
Here you will notice that we have just changed the contents of the Student object and we have not changed the value of student reference variable. i.e. we are not assigning a new Student object to the variable. This does not violate the final variable condition.

If we do,


final Student student = new Student();
student.setName("Prasad");
System.out.println("name = " + student.getName());
student = new Student(); // this does not compile
1
2
3
4
final Student student = new Student();
student.setName("Prasad");
System.out.println("name = " + student.getName());
student = new Student(); // this does not compile
then the result is as expected, it does not compile because we are assigning a the reference variable to a new Object which is not allowed for final variable.*/