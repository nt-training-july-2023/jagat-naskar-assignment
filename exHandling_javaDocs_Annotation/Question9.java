package exHandling_javaDocs_Annotation;

import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) throws NotEvenNumberException {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter a number: ");
			int num = scanner.nextInt();
			if(num%2 == 0)
				System.out.println("The number is even.");
			else throw new NotEvenNumberException("Number is odd or non-numeric value...");
		}catch (NotEvenNumberException e) {
			System.out.println("....NotEvenNumberException....");
		}
		finally {
			scanner.close();
		}
		
	}

}
