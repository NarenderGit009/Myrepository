package Meme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStr {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Emp emp=null;
		
		File file=new File("C:\\Users\\Aswitha\\Desktop\\abc.txt");
		FileInputStream out=new FileInputStream(file);
		ObjectInputStream oin=new ObjectInputStream(out);
		emp=(Emp) oin.readObject();
		
		oin.close();
		out.close();
		System.out.println(emp.empName);
		System.out.println(emp.address);
	}
}
