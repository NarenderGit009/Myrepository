package Anny;

public class ExceptonHanding {

	public static void main(String[] args) {
		
		try{
			ageCheck(12/0);
		}
		catch(Exception e){
			System.out.println("exception occured "+e);
		}
	}
	
	public static void ageCheck(int age) throws InvalidAgeException,ArithmeticException
	{
		if(age<=0){
			throw new InvalidAgeException("Please enter correct age");
		}else{
			System.out.println("Your age is "+age);
		}
	}
}
