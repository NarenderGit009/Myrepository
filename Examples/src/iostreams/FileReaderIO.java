package iostreams;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderIO {

	public static void main(String[] args) throws IOException{
		
		FileReader fr=null;
		
		try{
			fr=new FileReader("C:/Users/Aswitha/Desktop/JAVA/Input.txt");
			int i;
			while((i=fr.read())!=-1){
				System.out.print((char)i);
			}
			
		}
		finally{
			fr.close();
		}
	}
}
