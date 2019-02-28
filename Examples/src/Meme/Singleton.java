package Meme;

public class Singleton {

	private static Singleton singleTon=null;
	public String s;
	private Singleton(){
		s="Hello I am a string part of Singleton class ";
	}
	
	public static Singleton getInstance(){	
		
		if(singleTon==null)
			singleTon=new Singleton();
		
		return singleTon;
		
	}
	
	public static void main(String[] args) {
		 Singleton x = Singleton.getInstance(); 
		  
	        // instantiating Singleton class with variable y 
	        Singleton y = Singleton.getInstance(); 
	  
	        // instantiating Singleton class with variable z 
	        Singleton z = Singleton.getInstance(); 
	  
	        // changing variable of instance x 
	        x.s = (x.s).toUpperCase(); 
	  
	        System.out.println("String from x is " + x); 
	        System.out.println("String from y is " + y); 
	        System.out.println("String from z is " + z); 
	}
}
