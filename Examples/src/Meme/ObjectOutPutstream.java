package Meme;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutPutstream {
  public static void main(String[] args) throws IOException {
	Emp emp=new Emp();
	emp.empName="Aswitha";
	emp.address="J.gutta";
	
	File file=new File("C:\\Users\\Aswitha\\Desktop\\abc.txt");
	FileOutputStream out=new FileOutputStream(file);
	ObjectOutputStream oout=new ObjectOutputStream(out);
	
	oout.writeObject(emp);
	
}
}
