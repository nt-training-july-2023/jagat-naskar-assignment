package map;

import java.util.HashMap;
import java.util.Scanner;

public class Question3 {
//	Given an integer representing the threshold size, 
//	write a method which would print all the
//	elements existing in the map and then clear the map 
//	if the size of the map is equal to or greater
//	than the threshold size provided as input. 
//	There would be another method which would add the
//	elements in the map.
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("Enter threshold value:");
		int threshold = scanner.nextInt();
		System.out.println("How many element you want to enter: ");
		int n = scanner.nextInt();
		Question3 question3 = new Question3();
		for(int i = 0; i<n; i++)
		{
			question3.add(map);
		}
		System.out.println(map);
		if(map.size() > threshold)
			map.clear();
		System.out.println(map);
	}
	
	public void add(HashMap<Integer, String>map) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter key: ");
		int key = scanner.nextInt();
		System.out.println("Enter value: ");
		String valueString = scanner.next();
		map.put(key, valueString);
		System.out.println("Element added...");
	}
	
	
}
