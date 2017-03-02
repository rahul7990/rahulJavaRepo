package code.java.string;

final class immutable
{
final String str;

public immutable(String str)
{
	this.str=str;

}


public String getString()
{
return str;	
}

}

public class ImmutableClass {

	public static void main(String[] args) {
		immutable im = new immutable("Rahul");
		System.out.println(im.getString());
	}
	
}
