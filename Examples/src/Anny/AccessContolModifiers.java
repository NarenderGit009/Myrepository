package Anny;

public class AccessContolModifiers extends NonAccessModifers {

		private String name;
		//private
		//public
		//proected
		//no modefier
		public void setName(String name){
			this.name=name;
		}
		public String getName(){
			return this.name;
			
		}
		
		public static void main(String[] args) {
			
		}
		@Override
		void first() {
			// TODO Auto-generated method stub
			System.out.println("m abstact method" );
		}
}
