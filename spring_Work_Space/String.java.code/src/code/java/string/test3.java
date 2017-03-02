package code.java.string;


class test3{ 
public static void main(String[] args) {
	String Str = new String("Rahul Singh Rawat");

    System.out.println("Return Value 1 :" );
 
      // String arr[] =Str.split(" ");
       String arr[] =Str.split("\\s");
     
       for (int i = arr.length-1; i >= 0 ; i--) {
		System.out.print(arr[i]+"\t");
	}
}	
		
	
}

	
//  public static  void main(String[] args) {
//   String s = "Neil Peart rocks YYZ";
//   String[] str =s.split(" ");
//    StringBuffer buffer = new StringBuffer();
//  for(int i=str.length-1;i>=0;i--)
//  {
//       buffer.append(str[i]);
//       buffer.append(" ");
//   }
//   System.out.println("\nOriginal string: " + s);
//    System.out.println("Reverse word string:"+buffer.toString());
//    }

	

