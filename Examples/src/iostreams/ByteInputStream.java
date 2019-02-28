package iostreams;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteInputStream {

	public static void main(String[] args) throws IOException{
		
		FileInputStream fis=null;
		
		try{
			
			fis=new FileInputStream("C:/Users/Aswitha/Desktop/JAVA/Input.txt");
			
			/*int i=fis.read();
			while(i!=-1){
			System.out.println((char)i);}*/
			
			int i=0;
			
			while((i=fis.read())!=-1){

				System.out.println((char)i);
			}
		}
		finally{
			fis.close();
		}
	}
}
