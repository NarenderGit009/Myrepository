package Anny;

import java.util.ArrayList;
import java.util.Iterator;

public class TestCollection {
	
	Student s1=new Student(101, "Anny", 5);
	Student s2=new Student(102, "Funny", 11);
	Student s3=new Student(103, "Billu", 8);
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Anny");
		al.add("Funny");
		al.add("Billu");
		//two ways to iterate objects in java colletion
		/*Iterator i = al.iterator();
		while(i.hasNext())
		{
			System.out.println("Hi buddies "+i.next());
		}*/
		
		/*for(String obj:al)
		{
			System.out.println("Hi "+obj);
		}*/
		
		Iterator it = al.iterator();
		
		while(it.hasNext()){
			Student st = (Student) it.next();
			System.out.println(st.rollNum+" "+st.name+" "+st.age);
		}
	}
	
	
	
}
