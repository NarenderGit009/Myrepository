package Anny;

public class StaticVariables {

		static String sum ="Sum is: ";
		static String sub = "sub is :";
		
		static void change(){
			sum="Changed sum is :";
		}
		public static void main(String[] args) {
			
			int a=10;
			int b=20;
			int c=a+b;
			int d=a-b;
			//StaticVariables st = new StaticVariables();
			StaticVariables.change();
			System.out.println(sum+c);
			System.out.println(sub+d);
		}
		
}
