package Anny;

public class Dog extends Animal{

	static Animal a=null;
	static{
		Animal a=new Animal();
	}
	void doBark(){
		System.out.println("Bow bow bow....");
		
	}
}
