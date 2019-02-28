package iostreams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx {

	public static void main(String[] args) throws IOException {
		
		ObjectOutputStream out=null;
		
		Employee e=new Employee();
		e.name="Narender";
		e.address="Hyderabad";
		
		try{
			
			FileOutputStream fout=new FileOutputStream("C:/Users/Aswitha/Desktop/JAVA/Output.txt");
			out=new ObjectOutputStream(fout);
			System.out.println("Serialization has been done forEmployee Object");
			out.writeObject(e);
			fout.close();
		}
		finally{
			out.close();
			
		}
	}
}
