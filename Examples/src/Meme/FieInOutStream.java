package Meme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FieInOutStream {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in=null;
		FileOutputStream out=null;
		
		File file=new File("C:\\Users\\Aswitha\\Desktop\\abc.txt");
		/*File file1=new File("C:\\Users\\Aswitha\\Desktop\\zzzz.txt");
		in=new FileInputStream(file1);
		out = new FileOutputStream(file);
		int c;
		while((c=in.read())!=-1){
			out.write(c);
		}*/
		String s="Hi this Narender";
		
		byte[] b=s.getBytes();
		out=new FileOutputStream(file);
		out.write(b);
		
		in=new FileInputStream(file);
		//int i=in.read();
		int c;
		while((c=in.read())!=-1){
			System.out.println((char)c);
	
		}
		
		
		if(in!=null){
			in.close();
		}
		if(out!=null){
			out.close();
		}
		System.out.println("file has been created");
	}
}
