package iostreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserializationEx {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Employee emp=null;
		
		try{
			FileInputStream fis=new FileInputStream("C:/Users/Aswitha/Desktop/JAVA/Output.txt");
			ObjectInputStream oin = new ObjectInputStream(fis);
			emp=(Employee) oin.readObject();
		}finally{
			System.out.println("name "+emp.name +" address "+emp.address);
			
		}
	}
}
