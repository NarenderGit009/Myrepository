package rely.in;

public class Multithread1 extends Thread {

	public Multithread1() {
		// TODO Auto-generated constructor stub
	}
	public void run(){
		try{
			System.out.println("Thread is executing now....");
			
			
		}
		catch(Exception e){
		
			System.out.println(e);
		}
		System.out.println("aadasda");
	}
	
	public static void main(String[] args) {
		
		Multithread1 mt=new Multithread1();
		mt.start();
		mt.start();
		
	}
}
