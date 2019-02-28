package Meme;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
	
	public static void main(String[] args) throws IOException {
		
		
		FileWriter fw=null;
		FileReader fr=null;
		File file=new File("C:\\Users\\Aswitha\\Desktop\\abc.txt");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter  a word");
		try {
			/*fw=new FileWriter(file);
			String s="Hello, this is Aswitha";
			fw.write(s);*/
			
			fr=new FileReader(file);
			int i;
			//int i;
			while((i=fr.read())!=-1){
				System.out.println((char)i);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fw!=null){
			fw.close();}
			fr.close();
		}
		
	}
}
