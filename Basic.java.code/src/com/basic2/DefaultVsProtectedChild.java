package com.basic2;

import com.basic.DefaultVsProtected;

public class DefaultVsProtectedChild extends DefaultVsProtected {

	public static void main(String[] args) {
		
		DefaultVsProtectedChild defaultVsProtectedChild = new DefaultVsProtectedChild();
		System.out.println(defaultVsProtectedChild.y);
		/*Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
			The field DefaultVsProtected.x is not visible*/
		System.out.println(defaultVsProtectedChild.y);
	}
}
