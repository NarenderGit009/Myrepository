package Anny;

public class Construtor {

	private static int x=20;
	private static int y=40;
	@SuppressWarnings("static-access")
	public Construtor(int x,int y) {
		this();
		this.x=x;
		this.y=y;
		// TODO Auto-generated constructor stub
	}
	public Construtor() {
		// TODO Auto-generated constructor stub
	}
	public void print(){
		int num =30;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Construtor c=new Construtor(20,20);
		System.out.println("X value is "+x+"yvalue is "+y);
	}
}
