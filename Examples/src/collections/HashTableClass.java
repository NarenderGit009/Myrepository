package collections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableClass {

	public static void main(String[] args) {
		
		Map<Integer, String> hashtable=new Hashtable<>();
		
		hashtable.put(1, "Anny");
		hashtable.put(2, "Narender");
		//hashtable.put(null, null);
		//hashtable.put(null, null);
		
		Iterator<Entry<Integer, String>> en=hashtable.entrySet().iterator();
		
		while(en.hasNext()){
			System.out.println("key "+en.next());
		}
		
	}
}
