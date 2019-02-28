package Meme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Meme {

	final int a =10;
	
	static int test(int a,int b) throws FileNotFoundException
	{
		
		File f=new File("C:/Users/Aswitha/Desktop/abc.txt");
		FileOutputStream fis=new FileOutputStream(f);
		try {
			fis.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fsfdsfd");
		}
		try{
		int c=a/b;
		
		System.out.println(c);
		}catch(ArithmeticException ae){
			System.out.println("number con't divide by zero");
		}
		
		try{
			int[] a1={1,2,3,4};
			
			System.out.println(a1[7]);
			
			}catch(ArrayIndexOutOfBoundsException ae){
				System.out.println("Arrayout off bound exception");
			}
		
		return a;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Meme m =new Meme();
		m.test(10, 10);
		
	}
}
