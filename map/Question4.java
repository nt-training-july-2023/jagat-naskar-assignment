package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Check whether the map contains the key or value.
public class Question4 {
	
	public static void main(String[] args) {
		Question4 question4 = new Question4();
		question4.containsKey();
	}
	/**
	 * 
	 */
	public void containsKey() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(44, "Anita");
		map.put(32, "Anil");
		map.put(5, "Andrew");
		map.put(41, "Abhishek");
		map.put(32, "Adil");
		//printing keyset
		System.out.println("The keys are: ");
		for(Integer i: map.keySet()) {
			System.out.print(i+", ");
		}System.out.println();
		//printing vlaues
		System.out.println("The values are: ");
		for(String i: map.values()) {
			System.out.print(i+", ");
		}System.out.println();
		
		//using entry set to traverse map
		for(Map.Entry<Integer, String> i: map.entrySet()) {
			System.out.println("Key :"+i.getValue()+", value :"+i.getKey());
		}
		
		//checking value with key
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a key to check its value: ");
		int k1 = scanner.nextInt();
		if(map.containsKey(k1))
			System.out.println("The key has value= "+(String)map.get(k1));
		else System.out.println("The key is not present.");
		
		//checking key with value
		System.out.println("Enter a value to check its' key: ");
		String v1 = scanner.next();
		if(map.containsValue(v1))
			for(Map.Entry<Integer, String> i: map.entrySet()) {
				System.out.println("-value :"+i.getValue()+", v1 :"+v1);

		//check later, its not working...
//				if(i.getValue().equals(v1))
//					System.out.println("1");
//					System.out.println("Value :"+i.getValue()+", key :"+i.getKey());
//					System.out.println("2");
//					break;
			}
		else System.out.println("The value is not present.");
				
	
		
	}


}
