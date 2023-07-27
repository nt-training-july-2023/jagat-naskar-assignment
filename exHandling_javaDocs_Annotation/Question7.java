package exHandling_javaDocs_Annotation;

import java.util.Scanner;

public class Question7 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int n = scanner.nextInt();
		int a[] = new int[n];
		try {
			for(int i = 0; i<n; i++)
			{
				System.out.println("Enter "+i+"th element: ");
				a[i] = scanner.nextInt();
			}
			System.out.println("Enter a index to fetch element from array: ");
			int index = scanner.nextInt();
			if(index <0 || index >n-1)
				throw new IndexOutOfBoundsException("Index is out of array");
			else if(a == null)
				throw new NullPointerException("Array does not have element.");
			else {
				System.out.println("Element at "+index+"index is "+a[index]);
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Message from indexOutOfBound, "+e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("MEssage from nullPointerExp, "+e.getMessage());
		}

	}

}


