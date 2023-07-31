package map;

import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		//Implement basic CRUD operations
		//(Add,Remove,Update,Get)
		//on the different types of Maps.
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		boolean t = true;
		Question2 question2 = new Question2();
		while(t == true) {
			System.out.println("\n-------------------");
			System.out.println("1. Add element:");
			System.out.println("2. Remove employee:");
			System.out.println("3. Update employee by emp id:");
			System.out.println("4. Get a particular employee details: ");
			System.out.println("5. Print employee details:");
			System.out.println("6. Exit");
			System.out.println("Select from the list: ");
			System.out.println("----------------------\n");
			int sc = scanner.nextInt();
			switch (sc) 
			{
				case 1: {
					question2.addEmp(map);
					break;
				}
				case 2: {
					System.out.println("Enter a emp id to remove: ");
					int id = scanner.nextInt();
					question2.removeEmp(map, id);
					break;
				}
				case 3:{
					System.out.println("Enter id: ");
					int id = scanner.nextInt();
					System.out.println("Enter new name to change: ");
					String name = scanner.next();
					question2.updateEmp(map, id, name);
					break;
				}
				case 4: {
					System.out.println("Enter employee id to see its' details: ");
					int id = scanner.nextInt();
					question2.getEmp(map, id);
					break;
				}
				case 5: {
					question2.iterateEmp(map);
					break;
				}
				case 6: {
					t = false;
					break;
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + sc);
			}
			
		}
		
	}
	
	public void getEmp(Map<Integer, String> emp, int id) {
		if(emp.containsKey(id)) {
			System.out.println("Employee Id = "+id+ ", Name = "+emp.get(id));
		}else System.out.println("The emp-id is not present in the database");
	}
	public void iterateEmp(Map<Integer, String> emp) {
		System.out.println(emp);
		System.out.println("_________________________");
		System.out.println();
	}
	
	public void updateEmp(Map<Integer, String> emp, int inputId, String newName) {
		if(emp.containsKey(inputId)) {
			emp.put(inputId, newName);
			
		}else System.out.println("Id not present in the database.");
	}
	
	public void removeEmp(Map<Integer, String>emp, int inputId) {
		if(emp.containsKey(inputId)){
			emp.remove(inputId);
		}
		else System.out.println("Your Emp id is not present in the database.");
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
