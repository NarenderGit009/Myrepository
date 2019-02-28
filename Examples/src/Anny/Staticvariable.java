package Anny;

public class Staticvariable {

	int rollNo;
	String name;
	static String college="GEC";
	
	public Staticvariable(int i, String s) {
		// TODO Auto-generated constructor stub
		rollNo=i;
		name=s;
				
	}
	
	void display(){
		System.out.println("Roll NO "+rollNo+" name is "+name+" College "+college);
		
	}
	
	public static void main(String[] args) {
		Staticvariable s=new Staticvariable(1, "Aswitha");
		Staticvariable s1=new Staticvariable(2, "Neeraja");
		System.out.println(college.hashCode());
		
		s.display();
		System.out.println(college.hashCode());
		s1.display();
		
	}
}
