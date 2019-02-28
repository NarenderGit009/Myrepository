package Anny;

public class UncheckedEx {

	public static void main(String[] args) {
		
		/*try{
		int x=10/0;
		System.out.println(x);}
		catch(ArithmeticException ae){
			System.out.println("the number connot be didvide by zero");
			
		}*/
		try{
		int arr[]={1,2,3,4,5};
		System.out.println(arr[3]);
		}
		catch(ArrayIndexOutOfBoundsException a){
			
			System.out.println("the size of array exceeding");
		}
		
	}
}