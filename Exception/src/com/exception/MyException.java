package com.exception;

public class MyException extends Exception{

	 private String message = null;
	 
	    public MyException() {
	        super();
	    }
	 
	    public MyException(String message) {
	    	super(message);
	        this.message = message;
	    }
	 
	    public MyException(Throwable cause) {
	       super(cause);
	    }
	 
	    @Override
	    public String toString() {
	        return message;
	    }
	 
	    @Override
	    public String getMessage() {
	        return message;
	    }
	
}


/*1) Don’t' use Exception to control application behavior. Exception handling is very expensive as it requires native calls to copy stack trace, each time exception is created.

2) While creating a custom exception, prefer to create an unchecked, Runtime exception than a checked exception, especially if you know that client is not going to take any reactive action other than logging.

3) If your custom exception is created by passing another exception, then always contain original Exception as a source; use constructor which takes Exception rather than only message String.

4) Apart from providing default no argument constructor on your custom Exception class, consider providing at least two more constructors, one which should accept a failure message and other which can accept another Throwable as the cause.

5) If possible, avoid creating custom Exception and re-use existing, standard Exception classes from JDK itself. Most of the time you will realize that all you need is a form of IllegalArgumentException or ParseException or something similar.

6) While defining custom Exception, one of the most common mistake programmer make is to think that constructor is inherited from java.lang.Exception class, for example, they think that their Exception class will automatically inherit default no argument constructor and the one which takes a String message. This is not true. The constructor is not inherited in Java, not even default constructor. It's actually added by the compiler rather than inherited from parent class. That's why I have declared two constructors, one with String parameter and other as Throwable parameter:

public NoSuchProductException(String message, int productId) {
        super(message);
        this.productId = productId;
    }

    public NoSuchProductException(String message, int productId, Throwable cause) {
        super(message, cause);
        this.productId = productId;
    }


This is actually the standard way of creating custom Exception in Java. In order to save time, you can even create a template of above class in Eclipse IDE.

7) For readable code, it's good practice to append the string Exception to the names of all classes that inherits (directly or indirectly) from the Exception class e.g. instead of naming your class IncorrectPassword, name it IncorrectPasswordException.


*/