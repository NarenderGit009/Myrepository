package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraylistClass {

	public static void main(String[] args) {
		
		
		List<String> list=new ArrayList<>();//It is not synchronized,it maintains  insertion order, it allows null and duplicate values.
		
		list.add("Anny");
		list.add("Narender");
		list.add("");
		list.add("Narender");
		
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		for(String s:list){
			System.out.println(s.hashCode());
		}
	}
}
