package map;

import java.util.HashMap;
import java.util.Scanner;
public class Question6 {
	public static void main(String[] args) {
		//Given a map, remove the key value pair
		//if and only if the key is mapped to that particular value.
		Question6 question6 = new Question6();
		question6.removeKeyValuePair();
	}
	public boolean removeKeyValuePair() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(44, "Anita");
		map.put(32, "Anil");
		map.put(5, "Andrew");
		map.put(41, "Abhishek");
		map.put(32, "Adil");
		System.out.println(map);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a key: ");
		int k= scanner.nextInt();
		System.out.println("Enter value: ");
		String v = scanner.next();
		

		if(map.containsKey(k))
			{
				if(map.containsValue(v)) {
					map.remove(k);
					System.out.println("Removed successful...");
					System.out.println(map);
					return true;
				}else System.out.println("Key is present but value is not present.");
			}
		else System.out.println("The key is not present.");
		return false;
	}
}
