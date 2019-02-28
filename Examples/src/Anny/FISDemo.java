package Anny;
import java.io.*;//import stamt
public class FISDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Aswitha\\Desktop\\zzzz.txt");//creting connection to the file,..it will throws IO exception, File not found exception
		
		int data;
		
		while((data = fis.read())!=-1){
			System.out.println(data+"   "+(char)data);// it will print the data
		}
		
		 
		fis.close();//it should close the connection.
		
	}

}
