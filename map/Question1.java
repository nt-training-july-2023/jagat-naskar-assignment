package map;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
//		Iterate through a map and print the key(Employee Id) for all the elements that contains string
//		provided as an input to the map (The name of the employee). Create another method to add
//		elements to the map. The map should have an integer as the key(Employee Id) and the string as
//		value (Employee name).

		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		boolean t = true;
		Question1 question1 = new Question1();
		while(t == true) {
			System.out.println("\n-------------------");
			System.out.println("1. Add element:");
			System.out.println("2. Print element:");
			System.out.println("3. Exit");
			System.out.println("Select from the list: ");
			System.out.println("----------------------\n");
			int sc = scanner.nextInt();
			switch (sc) 
			{
				case 1: {
					question1.addEmp(map);
					break;
				}
				case 2: {
					question1.iterate(map);
					break;
				}
				case 3: {
					t = false;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + sc);
			}
			
		}
		
	}
	
	public void iterate(Map<Integer, String> emp) {
		System.out.println(emp);
		System.out.println("_________________________");
		System.out.println();
	}
	
	public void addEmp(Map<Integer, String> emp) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("_____Add Emp_____");
		System.out.println("Enter employee id: ");
		int id = scanner.nextInt();
		System.out.println("Enter employee name: ");
		String nameString = scanner.next();
		emp.put(id, nameString);
	}
}