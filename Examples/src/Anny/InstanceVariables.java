package Anny;

public class InstanceVariables {

	int c; //instance variable
	
	public void sum(){
		 int a = 0;//local variable
		int b=20;
		c=a+b;
		System.out.println("the sum is "+c);
	}
	public void subtraction(){
		int a=10;
		int b=20;
		c=a-b;
		System.out.println("the sub is "+c);
	}
	
	public static void main(String[] args) {
		
		InstanceVariables in=new InstanceVariables();
		in.sum();
		in.subtraction();
	}
}

