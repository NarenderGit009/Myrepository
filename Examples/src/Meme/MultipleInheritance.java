package Meme;

interface Test3{
	void m();
}
interface Test2{
	void m();
	
}

public class MultipleInheritance implements Test2,Test3{
	static{
		 int a;
	}
	@Override
	public void m() {
		// TODO Auto-generated method stub
		
		int i=10/0;
		
		System.out.println(i);
	}
	public static void main(String[] args) {
		MultipleInheritance mi=new MultipleInheritance();
		mi.m();
	}

}
