package iostreams;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr=null;
		
		try{
			
			isr=new InputStreamReader(System.in);
			System.out.println("Enter 'q' Quit ");
			char c;
			do{
				c=(char) isr.read();
				System.out.print(c);
			}while(c!='q');
				
		}
		finally {
			isr.close();
		}
	}
}
