package threads;

class MysmpThread extends Thread{
	
	public static int myCount=0;
	public void run(){
		
		while(MysmpThread.myCount<=10){
			
			
			try {
				System.out.println("Child Thread "+(++MysmpThread.myCount));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				System.out.println("Child thread Finally block executed");
			}
		}
	}
}
public class RunThread {

	public static void main(String[] args) {
		MysmpThread thread1=new MysmpThread();
		System.out.println("Main thread Start ()");
		thread1.start();
		
		while(MysmpThread.myCount<=10){
			System.out.println("Main thread "+(++MysmpThread.myCount));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				System.out.println("Main thread Final block executed");
			}
		}
		System.out.println("Main thread End ()");
	}
}
