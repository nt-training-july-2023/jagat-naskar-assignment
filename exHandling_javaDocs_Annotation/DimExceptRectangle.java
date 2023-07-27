package exHandling_javaDocs_Annotation;


import java.util.Scanner;

public class DimExceptRectangle {

	public static void main(String[] args) {
		int width, length;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter width: ");
		width = scanner.nextInt();
		System.out.println("\nEnter length: ");
		length = scanner.nextInt();
		try {
			if(width <=0 || length<=0)
				throw new InvalidDimensionException("Invalid length or bredth...");
			else {
				System.out.println("Area of rectangle of length: "+length+", bredth: "+width+" = "+length*width);
			}
		}catch (Exception e) {
			System.out.println("Error, "+e.getMessage());
		}
		scanner.close();

	}

}
