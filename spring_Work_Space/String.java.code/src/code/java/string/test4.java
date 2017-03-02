package code.java.string;



public class test4 {
	public static void main(String[] args) {
		
	
	String str = new String("Rahul Singh Rawat");//luhar hgnis tawar
	String ss="";
    for(int i=str.length()-1; i>=0; i--){
    	ss=ss+str.charAt(i);
    	}
    for(int j=0; j<ss.length(); j++){
    	System.out.print(ss.charAt(j));
    }
    
  
	   
  
}
}