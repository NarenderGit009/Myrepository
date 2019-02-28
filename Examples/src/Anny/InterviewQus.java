package Anny;
class FinalizeDemo{
	
	protected void finalize() throws Throwable {
		
		System.out.println("Object Finalized ");
	}
}

class Point{
	
	int x;
	int y;
	
	void showPoint(){
		
		System.out.println("x is"+x + " "+y);
	}
}
public class InterviewQus {
	
	public static void main(String[] args) {
		
		int i =10; //Single value Container
		Integer iRef= new Integer(i);// boxed Construting the Object
		
		int j= iRef.intValue(); // Unboxing extracting value from Object
		
		// boxing and unboxing we can achieve by wrapper classes.
		
		Integer kRef=i;//Auto boxing (Integer kRef=new Integer();)
		
		int l=kRef;//Auto unboxing
		
		//object construction statement
		FinalizeDemo fRef=new FinalizeDemo();
		Point pRef=new Point();
		fRef=null;
		
		
		String str=new String("Hello");
		StringBuilder str1=new StringBuilder("Hello");
		StringBuffer str2=new StringBuffer("Hello");
		
		System.out.println("str "+str.hashCode());
		System.out.println("str1 "+str1.hashCode());
		System.out.println("str2 "+str2.hashCode());
		
		str.concat("Hi...");
		str1.append("Hi...");
		str2.append("Hi...");
		
		System.out.println("str "+str.hashCode() +" "+str);// imutable
		System.out.println("str1 "+str1.hashCode()+" "+str1);//Mutable
		System.out.println("str2 "+str2.hashCode()+ " "+str2);//Muable
		
		
		System.out.println("pRef "+pRef+"   "+pRef);
		
		System.gc();
		
		
		
	}
}
