package map;

import java.util.HashMap;

public class Question5 {

	public static void main(String[] args) {
		//Retrieve all the keys and all the values and print them
		//on the console separately.
		Question5 question5 = new Question5();
		question5.allKeysValue();

	}
	
	
	public void allKeysValue() {
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
	}

}
