package exHandling_javaDocs_Annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Question8 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file with path: ");
		String s = scanner.next();
		Reading reading = new Reading();
		reading.read(s);
		scanner.close();
	}

}

class Reading{
	public void read(String s) throws IOException
	{
		File file = null;
		BufferedReader br = null;
		
		try {
			file = new File(s);
			br = new BufferedReader(new FileReader(file));
			
			String st;
			 while ((st = br.readLine()) != null)
		            System.out.println(st);
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(br == null)
					throw new NullPointerException("Your file is not send in buffered.");
				br.close();
			}catch (Exception e) {
				System.out.println();
			}
				
		}
		
	}
}