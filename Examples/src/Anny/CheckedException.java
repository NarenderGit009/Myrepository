package Anny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedException {

	private static FileInputStream nul;

	public static void main(String[] args) throws IOException  {
		FileInputStream fis=nul;
		
		try {
			fis=new FileInputStream("C:\\Users\\Aswitha\\Desktop\\zzzz.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The specified fe is not t");
		}
		int k;
		try {
			while((k=fis.read())!=-1){
				System.out.println((char)k);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("The specified fe is not t");
		}
		
		fis.close();
	}
}
