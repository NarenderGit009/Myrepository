package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetClass {

	public static void main(String[] args) {
		
		
		Set<String> set=new HashSet<>();//it's not synchronized, doesn't allow duplicates, allows null values.
		
		set.add("Anny");
		set.add("Narender");
		set.add(null);
		set.add(null);
		set.add("Narender");
		
		for(String s:set){
			System.out.println(s);
			//set.remove(s);
		}
	}
}
