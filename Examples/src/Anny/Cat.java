package Anny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cat extends Animal {
	
	int noOfLegs;
	
	
	void doMeou() {
		System.out.println("Meou Meou ....");
		try{
		int i=10/0;
		System.out.println(i);}
		catch(ArithmeticException ae){
			System.out.println("We can't divide the number with Zero");
		
		}
		try {
			FileInputStream fis = new FileInputStream("c//zzz.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("the specified file is not available at that location");
		}
		
	}
	Cat(){
		super();
		this.setNoOfLegs(6);
		
	}
	
	public String name(String s){
		
		return s;
	}
	
}
