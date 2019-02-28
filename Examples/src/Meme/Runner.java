package Meme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		
		List<Laptop> laps=new ArrayList<>();
		
		laps.add(new Laptop("Dell", 16, 800));
		laps.add(new Laptop("Apple", 8, 1200));
		laps.add(new Laptop("acer", 6, 500));
		
		Comparator<Laptop> con=new Comparator<Laptop>()
		{

		
			public int compare(Laptop o1, Laptop o2) {
				if(o1.getPrice()<o2.getPrice())
				return 0;
				else
					return -1;
			}
			
			
		};
		Collections.sort(laps,con);
		
		for(Laptop l:laps){
			System.out.println(l);
		}
	}
}
