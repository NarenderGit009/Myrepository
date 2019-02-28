package Meme;



public class Test extends AbsTest {

	static int Pncode=506122;
	
	int add()
	{
		int a=10;
		String b="20";
		
		int c=a+Integer.parseInt(b);
		System.out.println("the sum is " +this.Pncode);
		return c;
	}
	public static void main(String[] args) {
		rely.Demo demo=new rely.Demo();
		rely.in.Demo demo1= new rely.in.Demo();
		Test t=new Test();
		t.add();
		t.Fuel();
		
	}
	void ac() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void powerWindow() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class AbsTest{
	
	int a=10;
	int b=20;
	final int c=10;
	
	public AbsTest() {
		// TODO Auto-generated constructor stub
		System.out.println("Absclass constructor"+super.getClass());
		
	}
	public static void main(String[] args) {
		System.out.println("main method calling");
	}
	void Fuel(){
		System.out.println("The fuel is Petrol");
	}
	abstract void ac();
	abstract void powerWindow();
}
