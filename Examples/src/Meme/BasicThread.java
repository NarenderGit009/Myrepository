package Meme;

public class BasicThread implements Runnable {

	public void run(){
		System.out.println("Thread is running...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread th=Thread.currentThread();
		System.out.println(th.getName());
	}
	public static void main(String[] args)  {
		BasicThread bt=new BasicThread();
		Thread th=Thread.currentThread();
		Thread t=new Thread(bt);
		Thread t1=new Thread(bt);
		Thread t2=new Thread(bt);
		t.start();
		
		//System.out.println(th.getName());
		//System.out.println(t1.getPriority());
		
	//	System.out.println(t1.isAlive());
		t1.start();
		//System.out.println(t.isAlive());
	}
}
