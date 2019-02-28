/**
 * 
 */
package rely.in;

public class Demo extends Child {

	
public void test(){
		
		System.out.println("Child class");
	}
	public static void main(String[] args) {
		Child child=new Demo();
		child.childMethod();
		
		
	}

}

class Child {
	
	public void childMethod(){
		System.out.println("Child Method");
	}
	
}
