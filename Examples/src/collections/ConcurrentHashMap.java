package collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.*;
public class ConcurrentHashMap {

	static Map<String,Integer> con=new Hashtable<>();
	
	public static void main(String[] args) {
		
		con.put("London", 20000);
		con.put("USA", 20034300);
		con.put("Austrailia", 434);
		con.put("jk", 3434);
		
		Iterator<String> keys=con.keySet().iterator();
		Iterator<Entry<String, Integer>> entryset=con.entrySet().iterator();
		/*while(keys.hasNext()){
			String key=keys.next();
			System.out.println(con.get(key));
			//con.put("Hyd", 2900);
		}*/
		for(Map.Entry<String, Integer> enrty:con.entrySet()){
			System.out.println("Key value "+enrty.getKey()+" Value "+enrty.getValue());
		}
		
		System.out.println(con.size());
	}
	
}
