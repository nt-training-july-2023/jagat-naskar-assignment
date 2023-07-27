package JavaPrograms;

public class ArraysProgram {
	//main method
	public static void main(String[] args) {
		//largest number of an array
		System.out.println("____________________________________");
		System.out.println("Largest ELEMENT ");
		System.out.println("____________________________________");
		int a[] = {1, 22, 333, 4444, 55555, 666666};
		int len = a.length;
		int max = a[0];
		//calculating max element
		for(int i = 1; i < len; i++)
		{
			if(a[i] > max)
				max = a[i];
		}
		System.out.println("The elements in the array are: ");
		for(int i = 0; i<len; i++)
		{
			System.out.print(a[i]+", ");
			
		}System.out.println();
		System.out.println("The largest element is "+max);
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("____________________________________");
		System.out.println("     Find average of numbers");
		System.out.println("____________________________________");
		int average = 0;
		//calculating the average of the array
		for(int i = 0; i < len; i++)
		{
			average = average+a[i];
		}
		System.out.println("Average of all the above numbers are: "+average/len);
		System.out.println("____________________________________");
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println();
		System.out.println("____________________________________");
		System.out.println("Rotate an array by two position ");
		System.out.println("____________________________________");
		System.out.println();
		System.out.println("The elements in the array are: ");
		for(int i = 0; i<len; i++)
		{
			System.out.print(a[i]+", ");
		}System.out.println();
		
		//calculation for rotation
		for(int i = 0; i <2; i++)
		{
			int kk = a[len-1];
			for(int j = len-1; j >0; j--)
			{
				
				a[j]=a[j-1];
				
			}
			a[0] = kk;
		}
		System.out.println("After Rotatation of an array by two position ");
		for(int i = 0; i<len; i++)
		{
			System.out.print(a[i]+", ");
		}System.out.println();
		
		System.out.println("____________________________________");
		System.out.println();
		System.out.println();
		System.out.println("____________________________________");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("        Add two Matrices ");
		System.out.println("____________________________________");
		System.out.println();
		int arr[][]= {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int brr[][] = {{11, 22, 33}, {44, 55, 66}, {77, 88, 99}};
		int crr[][] = new int[3][3];
		System.out.println("Array A ");
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j< arr[0].length; j++)
			{
				System.out.print(arr[i][j]+"   ");
			}System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j< arr[0].length; j++)
			{
				System.out.print(brr[i][j]+"   ");
			}System.out.println();
		}System.out.println();
		
		System.out.println("Addition of these two matrices are as follows: ");
		
		//doing addition
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j< arr[0].length; j++)
			{
				crr[i][j] = brr[i][j] + arr[i][j];
			}
		}
		
		//printing the result
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j< arr[0].length; j++)
			{
				System.out.print(crr[i][j]+"   ");
			}System.out.println();
		}System.out.println();
		
		
		

	}

}
