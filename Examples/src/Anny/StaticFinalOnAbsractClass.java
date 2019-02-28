package Anny;

public abstract class StaticFinalOnAbsractClass {
	 abstract void mi();
	 abstract void m2();//Defination/specfication
	
}

class Child extends StaticFinalOnAbsractClass{

	@Override
	void mi() {
		// TODO Auto-generated method stub
		System.out.println("I'm impletated in child");
	}

	@Override
	void m2() {
		// TODO Auto-generated method stub
		System.out.println("I'm impletated in child");
	}

	public static void main(String[] args) {
		StaticFinalOnAbsractClass sf;
		Child c=new Child();
		c.mi();
	}
}
