package sample;

public class StringClass {

	public static void main(String[] args) {
		
		String str="HI";
		StringBuilder sbuilder=new StringBuilder("HI");
		StringBuffer sbuffer=new StringBuffer("HI");
		
		str.concat("Hello");
		sbuilder.append("Hello");
		sbuffer.append("Hello");
		
		System.out.println(str);
		System.out.println(sbuilder);
		System.out.println(sbuffer);
	}
}
