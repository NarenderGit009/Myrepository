package java8features;

public class Greeter {
 
	public void greet(Greeting greeting){
		greeting.perform();
	}
	public static void main(String[] args) {
		Greeter greeter=new Greeter();
		Greeting helloWorldGreeting=new HelloWorldGreeting();
		
		
		Greeting myLambdaGreeting =() -> System.out.print("Hello World using lambda");
		
		Greeting innerClassGreeting=new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("Hello World using InnerClass");
				
			}
		};
		
		greeter.greet(innerClassGreeting);
		greeter.greet(myLambdaGreeting);
	//	innerClassGreeting.perform();
		/*System.out.println("*****************Using traditiona OOP************");
		helloWorldGreeting.perform();
		System.out.println("*****************Using Lambda Expressions************");
		
		myLambdaGreeting.perform();
		//greeter.greet(helloWorldGreeting);
*/	}
}

/*interface MyLabda{
	void foo();
	//void add(int a, int b);
}*/