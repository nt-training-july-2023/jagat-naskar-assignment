package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Question2 {

	public static void main(String[] args) {
		System.out.println("___Question2___");
//		● Create a String collection and store 20 elements in it
//		● Elements stored should not be repeated.
//		● Elements stored should preserve the insertion order
//		● Implement different methods for this collection
		A a = new A();
		a.nonRepetative();

	}

}

class A{
	public void nonRepetative() {
		System.out.println("Enter 20 string: ");
		Set<String> set = new LinkedHashSet<String>();
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i<5; i++)
		{
			System.out.print("\nElement "+(i+1)+" : ");
			String input = scanner.next();
			set.add(input);
		}
		System.out.println(set);
	}
}