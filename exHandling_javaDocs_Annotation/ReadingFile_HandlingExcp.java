package exHandling_javaDocs_Annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFile_HandlingExcp {

	public static void main(String[] args) throws IOException {
		 try {
			 File Obj = new File("C:\\Users\\jagat\\eclipse-workspace\\JavaPractise\\src\\exHandling_javaDocs_Annotation\\file.txt");
			 if(!Obj.exists())
		            Obj.createNewFile();  
			 
			 
	            
	            //writing file
	            int i =1;
	            System.out.println("___________Writing!!!______________________");
	            FileWriter Writer = new FileWriter("file.txt");
	            Writer.write(i+". +++++Hi, writing from java file!!+++++");
	            Writer.close();
	            System.out.println("_______Successfully written_________");
	            
	            
	            //reading file
	            Scanner scanner = new Scanner(Obj);
	            System.out.println("\n\n______Reading from file______________");
	            while (scanner.hasNextLine()) {
	                String data = scanner.nextLine(); 
	                System.out.println(data);
	            }
	            System.out.println("_____________Reading ended____________");
	            
	            
	            
	            
	            
	            scanner.close();
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("An error has occurred.");
	            e.printStackTrace();
	        }

	   }

}