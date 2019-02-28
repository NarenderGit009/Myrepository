package Anny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis=null;
		FileOutputStream fout=null;
		
		try {
			fis=new FileInputStream("C:/Users/Aswitha/Desktop/JAVA/Input.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fout=new FileOutputStream("C:/Users/Aswitha/Desktop/JAVA/Output.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int c=0;
		
		try {
			while((c=fis.read())!=-1){
				fout.write(c);
				System.out.println();
			}
			
			System.out.println("********Read and write operations are done************");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fis!=null){
				fis.close();
			}
			if(fout!=null){
				fout.close();
			}
			
		}
	}
}
