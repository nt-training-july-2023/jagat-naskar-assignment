package JavaPrograms;

import java.util.Scanner;

public class IterationLoops {

	public static void main(String[] args) {
		System.out.println("____________________________________");
		System.out.println("Displaying table");
		System.out.println("____________________________________");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to see its table: ");
		int n = sc.nextInt();
		for(int i = 1; i<11; i++)
		{
			System.out.println(n +"x"+i+" = "+n*i);
		}System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Sum of first n numbers");
		System.out.println("____________________________________");
		int a[] = {3, 4, 6, 44, 43, 2, 3, 4, 5, 897};
		System.out.print("Elements are: ");
		for(int i = 0; i <a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.print("How many numbers you want to add from the first: ");
		int k = sc.nextInt();
		int sum = 0;
		for(int i = 0; i <k; i++)
		{
			sum+= a[i];
		}System.out.println("Sum of first "+k+" numbers = "+sum);
		
		System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Factorial of a number");
		System.out.println("____________________________________");
		System.out.print("Enter a number: ");
		n= sc.nextInt();
		sum = 1;
		for(int i = 2; i<=n; i++)
		{
			sum *= i;
		}System.out.println("The factorial of "+n+" = "+sum);
		
		
		
		System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("      Armstrong Number");
		System.out.println("____________________________________");
		
	
		System.out.print("Enter a number: ");
		n= sc.nextInt();
		boolean b=false;
		
		int m = n;
		sum = 0;
		while(m!=0) {
			int rem = m%10;
			sum += Math.pow(rem, 4);
			m = m/10;
		}
		if(sum == n)
			b = true;
		System.out.println(n+" is armstrong number = "+b);
		
		
		System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Reverse a number");
		System.out.println("____________________________________");
		
		System.out.print("Enter a number: ");
		n= sc.nextInt();
		m=n;
		int rev=0;
		while(m!=0) {
			int rem = m%10;
			rev = rev*10 +rem;
			m = m/10;
		}
		
		System.out.println("Reverse of "+n+" = "+rev);

		
		
		System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("        Palindrome Number");
		System.out.println("____________________________________");
		
		System.out.print("Enter a number: ");
		n= sc.nextInt();
		m=n;
		b = false;
		rev=0;
		while(m!=0) {
			int rem = m%10;
			rev = rev*10 +rem;
			m = m/10;
		}
		if(n == rev)
			b = true;
		System.out.println(n+"is a palindrome number = "+b);

		System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("           Pyramid");
		System.out.println("____________________________________");
		for(int i = 1; i<6; i++)
		{
			for(int j = 0; j <i; j++)
				System.out.print(i+" ");
			System.out.println();
		}
		
	}

}
