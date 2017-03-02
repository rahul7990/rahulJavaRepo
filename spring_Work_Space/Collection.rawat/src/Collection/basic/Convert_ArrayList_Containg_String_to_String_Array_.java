package Collection.basic;

import java.util.ArrayList;

public class Convert_ArrayList_Containg_String_to_String_Array_ {

	public static void main(String[] args) {
	
		ArrayList list = new ArrayList();
		list.add("Rahul");
		list.add("Rawat");
		list.add("Singh");
		list.add("Done");
		System.out.println(list);
		
		String []str = (String[]) list.toArray(new String[list.size()]);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

}
