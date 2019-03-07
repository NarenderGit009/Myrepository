package java8features;

public class TypeInferenceExample {

	public static void main(String[] args) {
		
		//StringLengthLambda myLambda=(String s)-> s.length();
		
		//StringLengthLambda mylambda=(s)-> s.length();
		
		StringLengthLambda mylambda	=s->s.length();
		
		System.out.println(mylambda.getLength("Hello Lambda"));

	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}
}
