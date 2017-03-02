package Collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class user{
	
	String username;
	String password;
	
	public user(){
		
	}
	
	public user(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + "]";
	}
	
	
}
public class TestComparatorInner {

	public static void main(String[] args) {
		
		user user1 = new user("Rahul","uhfiuhfiurh");
		user user2 = new user("giri","uhfiuhfiurh");
		user user3 = new user("vikas","uhfiuhfiurh");
		user user4 = new user("raman","uhfiuhfiurh");
		
		List<user> list = new ArrayList();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		
		
		Collections.sort(list, new Comparator<user>() {

					@Override
					public int compare(user u1, user u2) {
						return u1.username.compareTo(u2.username);
					}
		});
		
		System.out.println(list);
		
	}
}
