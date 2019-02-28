package Anny;

public class AnonymousObj {

	static int k;
	void show(int a){
		System.out.println(this.k);
	}
	public static void main(String[] args) {
		new AnonymousObj().k=29;
		new AnonymousObj().show(k);
		new AnonymousObj().show(k);
	}
}
