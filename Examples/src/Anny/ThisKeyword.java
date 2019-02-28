package Anny;

public class ThisKeyword {
	//instance variable
	int num =10;
	
	public ThisKeyword() {
		// TODO Auto-generated constructor stub
		System.out.println("Example of this keyword");
	}
	ThisKeyword(int num){
		
		//this();
		this.num=num;
		
	}
	public void great(){
		System.out.println("Hi welcome to this keyword");
	}
	public void print(){
		int num =20;
		System.out.println("local variable "+num);
		System.out.println("instance variable "+this.num);
	}
	public static void main(String[] args) {
		
		ThisKeyword th = new ThisKeyword(40);
		System.out.println(th.hashCode());
		th.print();
		th.great();
	}
}
