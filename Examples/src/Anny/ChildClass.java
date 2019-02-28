package Anny;



 class InheritanceConcepts {

	int a=10;
	int b=20;
	
	public int sum(){
		int c=a+b;
		return c;
	}
}
public class ChildClass extends InheritanceConcepts{
	
	
	
	public int sum(){
		int c=a+b;
		return c;
	}
	public static void main(String[] args) {
		ChildClass cc=null;
		InheritanceConcepts in=null;
		
		cc=new ChildClass();
		in=new InheritanceConcepts();
		System.out.println("the sum is "+cc.sum());
		System.out.println("the sum is "+in.sum());
		
	}
}

