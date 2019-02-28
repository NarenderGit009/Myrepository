package Meme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionEx {

	public static void main(String[] args) {
		
		/*List<String> list=new ArrayList<String>();
		list.add("Narender");
		list.add("Funny");
		list.add("Anny");
		
		System.out.println(list);
		
		Iterator<String> iterator=list.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			iterator.remove();
			
		}*/
		
		/*List<String> link=new LinkedList<String>();
		
		link.add("Narender");
		link.add("Funny");
		link.add("Anny");
		link.add(null);
		
		
		Iterator<String> it=link.iterator();
		System.out.println(link);
		
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		/*List<String> vector=new Vector<String>();
		
		vector.add("Narender");
		vector.add("Anny");
		vector.add("Anny");
		vector.addAll(null);
		
		Iterator<String> it=vector.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			System.out.println();
		}*/
		
		/*Queue<String> q=new PriorityQueue<>();
		
		q.add("Narender");
		q.add("Anny");
		q.add("Anny");
	//	q.add(null);
		
		System.out.println(q);
		
		Iterator<String> it=q.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}*/
		
/*Queue<String> q=new LinkedList<>();
		
		q.add("Narender");
		q.add("Anny");
		q.add("Anny");
	q.add(null);
		
		System.out.println(q);
		
		Iterator<String> it=q.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}*/
		
		
		/*Set<String> set=new HashSet<>();
		
		set.add("Narender");
		set.add("Narender");
		set.add("Anny");
		set.add(null);
		
		System.out.println(set);
		
		
		Iterator<String> it= set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		/*Set<String> set= new LinkedHashSet<String>();
		set.add("Narender");
		set.add("Narender");
		set.add("Anny");
		set.add(null);
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
		System.out.println(it.next());
	}*/
		
		/*Set<String> set= new TreeSet<String>();
		set.add("Narender");
		set.add("Narender");
		set.add("Anny");
		
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
		System.out.println(it.next());
	}*/
		
		/*Map<Integer, String> map=new HashMap<>();
		
		map.put(1, "Narender");
		map.put(2, "Anny");
		map.put(3, "Narender");
		//map.put(null, null);
		map.put(4, null);
		
		System.out.println(map);
		
		Iterator it=map.entrySet().iterator();
		while(it.hasNext()){
			
			String key=it.next().toString();
			String value=it.next().toString();
			
			System.out.println(key+"  "+value);
			
		}*/
		
Map<String, String> map=new Hashtable<>();
		
		map.put("1", "Narender");
		map.put("2", "Anny");
		map.put("3", "Narender");
	//map.put(null, null);
		//map.put(4, null);
		
		System.out.println(map);
		
		Set<String> set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			
			String key=it.next().toString();
			String value=(String) it.next();
			
			System.out.println(key+"  "+value);
			
		}
		
		
	}
}
