package Anny;

import java.util.ArrayList;
import java.util.Vector;

public class JavaColExample {

	public static void main(String[] args) {
		
		ArrayList<String> list=new ArrayList<String>();
		Vector<String> vector=new Vector<String>();
		
		list.add("Asitha");
		list.add("Neeru");
		list.add("Naren");
		list.add("Funny");
		list.add("Funny");
		list.add("Null");
		
		
		vector.add("Aswitha");
		vector.add("Neeru");
		vector.add("Naren");
		vector.add("Funny");
		vector.add("Funny");
		vector.add("Null");
		//list.remove(3);
		
		//System.out.println(list);

		/*int i = list.indexOf("funny");
		System.out.println(i);
		for(String str:list){
			System.out.println(str);
		}*/
		
		System.out.println(vector);
		
	}

}
