package Anny;

public class DataHiding {

	/*Data hiding "Our internal data should not go out directly that is outside person can't access our internal data directly*/
	/*By using private modifier we can implement data hiding*/
	private int i;
	
	private void dataHiding(){
		System.out.println("Hey Data Hiding");
	}
	public static void main(String[] args) {
		DataHiding dh = new DataHiding();
		dh.dataHiding();
	}
}
