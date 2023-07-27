package exHandling_javaDocs_Annotation;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadingWriting {

	public static void main(String[] args) throws Exception {
		String fileReadName;
		String fileWritingName;
		Scanner scanner = new Scanner(System.in);
		ReadAndWrite readAndWrite = new ReadAndWrite();
		
		try {
			System.out.println("Enter the file  name with destination to read: ");
			fileReadName = scanner.next();
			readAndWrite.read(fileReadName);
			
			System.out.println("\n\n\nEnter file name with destination to Write...: ");
			fileWritingName = scanner.next();
			readAndWrite.write(fileReadName, fileWritingName);
		}catch (IOException e) {
			System.out.println("Throwing error from main method to read!! check properly, "+e.getMessage());
		}
		
	}

}


class ReadAndWrite{
	//C:\Users\jagat\eclipse-workspace\JavaPractise\src\exHandling_javaDocs_Annotation\file.txt
	public void read(String f) throws Exception {
		FileReader fr=null;
		try {
			System.out.println("\n\n_______Reading____________");
			 fr=new FileReader(f);
          int i;    
          while((i=fr.read())!=-1)    
          System.out.print((char)i);  
          //fr.close();   
		}catch (FileNotFoundException e) {
			System.out.println("file not found!!!, "+e.getMessage());
		}
		finally {
			
		}
          
	}
	
	public void write(String r, String w)throws Exception{
		try {
			System.out.println("\n\n\n_______Writing_________________");
			FileWriter writer = new FileWriter(w);  
		    BufferedWriter buffer = new BufferedWriter(writer);  
		    buffer.write("Hey, I am writing from write method in "+w);  
		    
		    
		    FileReader fr=new FileReader(r);    
	          int i;    
	          while((i=fr.read())!=-1)    
	          {
	        	  char ch = (char)i;  
	        	  buffer.write(ch);
	          }
		    
		    System.out.println("Written file ");
		    System.out.println("-------------");
		    read(w);
		    
	        fr.close(); 
		    buffer.close();  
		    System.out.println("Writing Successful");  
		}catch (FileNotFoundException e) {
			System.out.println("file not found!!!, "+e.getMessage());
		}
	}
}

//C:\Users\jagat\eclipse-workspace\JavaPractise\src\OppsConcept\Info.properties

//C:\Users\jagat\eclipse-workspace\JavaPractise\src\exHandling_javaDocs_Annotation\write.txt