package Anny;

public class Constructor {

	public Constructor() {
		// TODO Auto-generated constructor stub
		System.out.println("I'm constructor");
	}
	
	public int ifCond(int i){
		
		
		if(i==0){
			System.out.println("i value is "+i);
		}else if(i<0){
			System.out.println("i value nagative"+i);
		}else{
			System.out.println("i value is "+i);
		}
		return i;
		
		
	}
	
	public String switchCase(String s){
		
		
		switch(s){
		
		case "Neeraja": System.out.println("I'm neeraja");break;
		case "Narender": System.out.println("I'm Narender");break;
		case "Aswitha": System.out.println("I'm Aswitha");break;
		default : System.out.println("U r name not found");
		}
		return null;
		
	}
	
		
	
	public static void main(String[] args) {
		
		Constructor c = new Constructor();
		c.ifCond(2);
		c.switchCase("Narendewr");
		
	}
}
