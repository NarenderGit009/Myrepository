package Meme;

interface Test1{
	int a=0;
	
}
final class OverloadingMain extends AbsTest {

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Object detroyed");
	}	
	void main(){
		System.out.println("main 1");
	}
	void test(){
		
	}
	static void main(int x){
		System.out.println("main 2"+x);
	}
	public static void main(String[] args) {
		OverloadingMain o=new OverloadingMain();
		System.out.println(o.toString().hashCode());
		o.main();
		OverloadingMain.main(10);
	}
	@Override
	void ac() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void powerWindow() {
		// TODO Auto-generated method stub
		
	}
}
