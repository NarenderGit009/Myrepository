package collections;
import java.util.*;
public class VectorClass {
	public static void main(String[] args) {
		
		Vector<String> vector=new Vector<String>();//Vector maintain the insertion order,allows the null values and duplicates values.
		
		vector.add("Anny");
		vector.add("Narender");
		vector.add("Neeraja");
		vector.add("");
		vector.add("Anny");
		vector.add("Anny");
		vector.add("Narender");
		vector.add("Neeraja");
		vector.add("");
		vector.add("Anny");
		Iterator<String> it=vector.iterator();
		Enumeration<String> er=vector.elements();
		
		/*while(er.hasMoreElements()){
			System.out.println(er.nextElement());
		//	System.out.println(er.hashCode());
			vector.add("null");
		}*/
		while(it.hasNext()){
			System.out.println(it.next());
			//vector.add("null"); //Vector is fail fast operation, you con not modify,add or remove the objects from vector collections, if we try 
			//to modify will get java.util.ConcurrentModificationException
		}
		
	}
}
