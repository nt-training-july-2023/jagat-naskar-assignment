package javaIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Question3 {

	public static void main(String[] args) throws IOException{
		System.out.println("Create a program to \"invert\" the contents of a text file: create a file with the same name ending in \".txt\" and containing the same lines as the original file but in reverse order (the first line will be the last one, the second will be the penultimate, and so on, until the last line of the original file, which should appear in the first position of the resulting file.)");
		System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		ReverseLineWriting reverseLineWriting1 = new ReverseLineWriting();
		reverseLineWriting1.readAndWrite();
		
	}

}


class ReverseLineWriting {

	public void readAndWrite() throws IOException {
		
		//reading from a file read.txt using buffered reader
		BufferedReader bReader=null;
		Stack<String> stck = new Stack<String>();
		String readingPath = "C:\\Users\\jagat\\eclipse-workspace\\JavaPractise\\src\\javaIO\\read.txt";
		try {
			bReader = new BufferedReader(new FileReader(readingPath));
			String read = bReader.readLine();
			while(read != null) {
				stck.push(read);
				read = bReader.readLine();
			}
			System.out.println("Reading successful");
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given path.");
		}
		
		
		System.out.println("............middle...................");
		//writing in reverse-line way in revLinesOfRead.txt file
		BufferedWriter bWriter=null;
		String writingPath = "C:\\Users\\jagat\\eclipse-workspace\\JavaPractise\\src\\javaIO\\revLinesOfRead.txt";
		try {
			bWriter = new BufferedWriter(new FileWriter(writingPath));
			int i=0;
			while(!stck.isEmpty()) {
				System.out.println(stck.peek()+" "+(i++));
				String kString = stck.pop()+"\n";
				bWriter.write(kString);
			}
			System.out.println("Writing Successful.");
		} catch (FileNotFoundException e) {
			System.out.println("File not found for writing.");
		}
		finally {
			bWriter.close();
			bReader.close();
		}
	
	
	}
}