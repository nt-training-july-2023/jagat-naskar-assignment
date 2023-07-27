package JavaPrograms;

import java.util.Scanner;

public class OperationAndExpression {

	public static void main(String[] args) {
		System.out.println("Operator and Expression");
		System.out.println("------------------------");
		System.out.println("Use of all the arithematic Operator");
		int a = 9;
		int b = 34;
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("a + b ="+(a+b));
		System.out.println("a - b ="+(a-b));
		System.out.println("a x b ="+(a*b));
		System.out.println("a / b ="+(a/b));
		System.out.println("a % b ="+(a%b));
		System.out.println("a++ ="+(++a));
		System.out.println("b-- ="+(--b));
		System.out.println();
		System.out.println("_______________________________________");
		
		
		
		
		
		
		System.out.println("Area of a triangle");
		System.out.print("Enter the base of the trianble: ");
		Scanner scanner = new Scanner(System.in);
		int base = scanner.nextInt();
		System.out.println();
		System.out.print("Enter the height of the triangle: ");
		int height = scanner.nextInt();
		System.out.println();
		System.out.println("The are of triangle of base = "+base +" height = "+height+" = "+(base*height)/2);
		System.out.println();
		System.out.println("_______________________________________");
		
		
		
		
		
		
		System.out.println("Roots of quadratic quation");
		System.out.println();
		System.out.println("Enter the value of b: ");
		b = scanner.nextInt();
		System.out.println("Enter the value of a: ");
		a = scanner.nextInt();
		System.out.println("Enter the value of c: ");
		int c = scanner.nextInt();
		
		float ans = (float) Math.sqrt((float) ((Math.pow(b, 2) - (4*a*c))/(2*a)));
		//If the discriminant is positive, then the roots are real and unequal.
		//If the discriminant is 0, then the roots are real and equal.
		//If the discriminant is negative, then the roots are unequal and imaginary.
		
		if(ans >0)
			System.out.println("The roots are real and unequal");
		else if(ans == 0)
			System.out.println("The roots are real and equal");
		else System.out.println("The roots are unequal and imaginary.");
			


		
		
		
		
		
		
		System.out.println();
		System.out.println("_______________________________________");
		
		System.out.println("Increment and Decrement Operators");
		System.out.println();
		
		System.out.println("a = "+a);
		System.out.println("a++ = "+a++);
		System.out.println("a = "+a);
		System.out.println(".................");
		System.out.println("++a = "+(++a));
		System.out.println("a = "+a);
		System.out.println(".................");
		System.out.println("--a = "+(--a));
		System.out.println("a = "+a);
		System.out.println(".................");
		System.out.println("a-- = "+(a--));
		System.out.println("a = "+a);
		System.out.println(".................");
		
		System.out.println("Post-Increment and then print");
		a++;
		System.out.println("a = "+a);
		System.out.println(".................");
		
		System.out.println("Post-Decrement and then print");
		a--;
		System.out.println("a = "+a);
		System.out.println(".................");
		
		System.out.println("Pre-Increment and then print");
		++a;
		System.out.println("a = "+a);
		System.out.println(".................");
		
		System.out.println("Pre-Decrement and then print");
		--a;
		System.out.println("a = "+a);
		System.out.println(".................");
		
		
		
		
		
		
		
		
		System.out.println();
		System.out.println("_______________________________________");
		
		System.out.println("Bitwise and Bit-shifting operators");
		System.out.println();
		
		System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
 
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
 
        System.out.println("Bitwise AND: " + (num1 & num2));
        System.out.println("Bitwise OR: " + (num1 | num2));
        System.out.println("Bitwise XOR: " + (num1 ^ num2));
        System.out.println("Bitwise NOT: " + (~num1));
        System.out.println("Bitwise Left Shift: " + (num1 << 2));
        System.out.println("Bitwise Right Shift: " + (num1 >> 2));
        System.out.println("Bitwise Unsigned Right Shift: " + (num1 >>> 2));
        
 
		
		
		
		
		
		
		
		
		
		
		
	}

}
