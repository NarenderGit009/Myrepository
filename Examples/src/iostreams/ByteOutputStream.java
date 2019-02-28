package iostreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputStream {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos=null;
		int a[]={80,91,80,80};
		try{
			
			String s="Hey this is Aswita";
			File file=new File("C:/Users/Aswitha/Desktop/JAVA/Output.txt");
			fos=new FileOutputStream(file);
			byte[] b=s.getBytes();
			fos.write(b);
			System.out.println("byte write operation has been done");
		}
		finally{
			fos.close();
		}
	}
}
