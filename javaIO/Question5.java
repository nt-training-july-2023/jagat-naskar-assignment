package javaIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Question5 {
	public static void main(String srgs[]) throws IOException {
		ReadingWriting readingWriting = new ReadingWriting();
		readingWriting.readAndWrite();
	}
}





class ReadingWriting {

	public void readAndWrite() throws IOException {
		
		//reading from a file read.txt using buffered reader
		BufferedReader bReader=null;
		BufferedWriter bWriter=null;
		String writingPath = "C:\\Users\\jagat\\eclipse-workspace\\JavaPractise\\src\\javaIO\\revLinesOfRead.txt";
		String readingPath = "C:\\Users\\jagat\\eclipse-workspace\\JavaPractise\\src\\javaIO\\read.txt";
		try {
			bReader = new BufferedReader(new FileReader(readingPath));
			bWriter = new BufferedWriter(new FileWriter(writingPath));
			String read = bReader.readLine();
			while(read != null) {
				if(bReader != null) {
					bWriter.write(read+"\n");
					read = bReader.readLine();
				}
			}
			System.out.println("Reading successful and writing successful.");
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the given path.");
		}finally {
			bWriter.close();
			bReader.close();
		}
	}
}