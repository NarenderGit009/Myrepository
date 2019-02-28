package sample;


/*final class Final{
	void main(){
		System.out.println("Final Class");//We can't inherite the final class
	}
}*/
public class FinalExample {

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Finalze Method will call before object is garbaged");
	}
	final int i=10;//We can't modify the final variable
	
	final void greeting(String s){
		System.out.println("Welcome "+s);
	}
	public static void main(String[] args) {
		
		FinalExample fe=new FinalExample();
		fe.greeting("Narender");
		
		int i=10;
		int j=0;
		try{
		int c=i/j;
		System.out.println(c);}
		catch(ArithmeticException ae){
			System.out.println("Number cannot devide by Zero");
		}finally{
			System.out.println("Let me clsoe the connection");
		}
		
		fe=null;
		System.gc();		
	}
}

/*class Sample extends FinalExample{
	final void greeting(String s){
		System.out.println("Welcome "+s);//We can't override the final methods
	}
}*/