package Anny;


/*class Shape{
	
	public void draw(){
		System.out.println("Draw Method calling");
	}
	
	}*/

/*abstract class Shape{
	
	public Shape() {
		// TODO Auto-generated constructor stub
		System.out.println("Consrtuctor");
	}
	abstract void draw();//doesn't have any defination for abstract methods, 
}*/

interface Shape{
	
	abstract void draw();
}
class Circle implements Shape {
	public void draw(){
		System.out.println("Circle");
	}
}


class Rectangle implements Shape{
	public void draw(){
		System.out.println("Rectangle");
	}
}


class Polygon implements Shape{
	public void draw(){
		System.out.println("Polygon");
	}
}
public class Polymorphism {

	public static void main(String[] args) {
		
		Shape s;
		//s = new Shape();
		//s.draw();
		
		s=new Circle();
		s.draw();
		
		s=new Rectangle();
		s.draw();
		
		s=new Polygon();
		s.draw();
	}
}
