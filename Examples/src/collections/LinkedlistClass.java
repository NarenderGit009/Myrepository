package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedlistClass {

	public static void main(String[] args) {
		
		List<String> linkedList = new LinkedList<>();//Linked list is not synchronized, Insertion and deletion of operations very fast i linked list,it allows duplicates and null values;
		
		linkedList.add("Anny");
		linkedList.add("Narender");
		linkedList.add("");
		linkedList.add("Narender");
		
		System.out.println(linkedList.hashCode());
		Iterator<String> it=linkedList.iterator();
		
		for(String s:linkedList){
			System.out.println(s);
			//linkedList.remove(2);//Gives concurrentmodificationexception
		}
		
		
	}
}
