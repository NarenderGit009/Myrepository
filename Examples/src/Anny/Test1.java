package Anny;

public class Test1 {

		int i;
		int j;
		int x;
		String s;
		
		public Test1(int i1, int j1){
			i=i1;
			j=j1;
			
			
		}
		public int display(){
			int sum2 = 0;
			String s1 = null;
			System.out.println("The values are "+i+" "+j+"  "+s1);
			int sum = i+j;
			return sum;
			
		}
		
		public String display(String s)
		{
			//System.out.println("Overloading "+s);
			return s;
		}
		public static void main(String[] args) {
			
			Test1 t1 = new Test1(10,20);
			
			System.out.println(t1.display());
			System.out.println(t1.display("Narender"));
		}
}
