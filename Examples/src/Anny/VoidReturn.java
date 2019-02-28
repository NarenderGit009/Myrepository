package Anny;

public class VoidReturn {

		public void voidMethod(){
			System.out.println("Im void method, does'nt retun any value");
		}
		public int sum(int a,int b){
			
			int c=a+b;
			return c;
		}
		public static void main(String[] args) {
			
			
			VoidReturn vr=new VoidReturn();
			System.out.println("the sum is "+vr.sum(10,20));
			vr.voidMethod();
			
		}
}
