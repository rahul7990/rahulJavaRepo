package com.externalization.rahul;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Watermalon implements Externalizable {

	String taste = "Sweet";
	int price = 40;
	
	@Override
	public void readExternal(ObjectInput objectinput) throws IOException,
			ClassNotFoundException {
		Object obj;
		
		
		while(!((obj = objectinput.readObject()) instanceof EofIndecator)){
			taste=objectinput.readUTF();
			
			price=objectinput.readInt();
		}
		objectinput.close();
	}

	@Override
	public void writeExternal(ObjectOutput objectoutput) throws IOException {
		
		//objectoutput.writeUTF(color);
        objectoutput.writeUTF(taste);	
        objectoutput.writeInt(price);
        objectoutput.writeObject(new EofIndecator());
	}

}
