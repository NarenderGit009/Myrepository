package Anny;

public class Test {

	 static{
		System.out.println("First");
		
	}
	 
	public static void main(String[] args) {
		Cat cat =new Cat();
		//cat.setNoOfLegs(4);
		//cat.setNoOfLegs(4);
		System.out.println("Cat have "+cat.getNoOfLegs()+" legs");
		cat.doMeou();
		
		Dog dog =new Dog();
		dog.setNoOfLegs(4);
		
		System.out.println("Dog have "+dog.getNoOfLegs()+ " legs");
		dog.doBark();
		
		Animal a=cat;//Up casting
		Cat c=(Cat) a;//Down catsing
		c.doMeou();
		
		System.out.println(c.name("Cat"));
		
		byte x=10;
		
		/*Byte b=Byte.valueOf(x);
		b.getClass();
		System.out.println(b);*/
		
		Byte b=new Byte(x);
		System.out.println(b);
	}
}
