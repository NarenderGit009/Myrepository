package Meme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Sample {

	int a;
	Sample(){
		
	System.out.println("default constructor called");	
		}
	
	public void showMethod(){

		List<String> list=new CopyOnWriteArrayList();
		
		for(int i=0;i<=20;i++){
			list.add("list"+i);
		}
		System.out.println(list.size());
		
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			list.add("sdsd");
		}
		
	}
	
	public static void main(String[] args) {
		
				Sample s=new Sample();
				//System.out.println(s.a);
				s.showMethod();
	}
}
