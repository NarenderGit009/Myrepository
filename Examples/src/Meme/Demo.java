package Meme;

public class Demo {

	
	int x=10;
	int y=0;
	int a=20;
	int b=0;
	void sum(){
	try{
		
		int z=x/y;
		System.out.println(z);
		int c=a/b;
		System.out.println(c);
	}
	catch(ArithmeticException ae){
		System.out.println("exception while a/b");
	}
	catch(Exception ae){
		System.out.println("exception while x/y");
	}
	}
	
	public static void main(String[] args) {
		
		Demo d=new Demo();
		d.sum();
		
	}
}
