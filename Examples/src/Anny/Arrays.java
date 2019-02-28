package Anny;

public class Arrays {

	String[] name ={"naender","sds","ssd"};
	
	public void names(){
		
//		for (int i = 0; i < name.length; i++) {
//			System.out.println(name[i]);
//		}
		
		for(String names:name){
			System.out.println(names);
		}
	}
	
	public void tables(int x){
		
		for (int i = 0; i <= 10; i++) {
			
			int j = x*i;
			System.out.println(""+x+"*"+i+"="+j);
		}
	}
	public static void main(String[] args) {
	Arrays a=new Arrays();
	a.names();
	a.tables(2);
	}
}
