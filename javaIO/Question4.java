package javaIO;

import java.io.File;

public class Question4 {

	public static void main(String[] args) {
		System.out.println("Write a Java program to get a list of all file/directory names from the directory: C://Documents.");
		System.out.println("_________________________________________________________________________________________________");
		DirectoryReading directoryReading = new DirectoryReading();
		directoryReading.readFlie("C:\\Users\\jagat\\OneDrive\\Documents");
	}

}


class DirectoryReading{
	
	public void readFlie(String path) {
		File file = new File(path);
		String arr[] = file.list();
		
		for(String s:arr) {
			
			File f1 = new File(file, s);
			if(!f1.exists())
				return;
			if(f1.isFile())
				System.out.println(s);
			else {
				String path1 = f1.getAbsolutePath();
				System.out.println("PAth1 = "+path1);
				readFlie(path1);
			}
		}
	}
}
