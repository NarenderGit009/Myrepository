package Anny;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterIO {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw=null;
		try{
			
			fw=new FileWriter("C:/Users/Aswitha/Desktop/JAVA/Output.txt");
			fw.write("Welcome to File Writer method");
			System.out.println("File writer operation has been done");
		}catch(FileNotFoundException fn){
			System.out.println("File writer operation has been done");
		}finally{
			fw.close();
		}
	}
}
