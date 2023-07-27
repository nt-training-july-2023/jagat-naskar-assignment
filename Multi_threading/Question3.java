package Multi_threading;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PP{
	public void print(int n) {
		System.out.println("___Print reverse()____");
		while(n!=0) {
			if(n== 3)
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println("rev= "+n+", ");
			n--;
		}
		System.out.println("\n\n");   
	}
	public void reverseList(List<Integer> list) {
		System.out.println("___reverseList()____");
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		//System.out.println(list2);
		System.out.println("\n\n");   
	}
	public void Fibonacci(int count)
	{
		System.out.println("___Fibonacci()____");
		int num1=0,num2=1,num3,i;    
		 System.out.print(num1+" "+num2);
		 for(i=2;i<count;++i)
		 {    
			 if(i >=3 && i<8)
				try {
					Thread.sleep(415);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  num3=num1+num2;    
		  System.out.print(", "+num3);    
		  num1=num2;    
		  num2=num3;    
		 }System.out.println("\n\n");   
	}
	
	public void sumOfAllNos(int a[])
	{
		System.out.println("______sumOfAllNos()______");
		int total = 0;
		for(int i = 0; i<a.length; i++)
		{
			total += a[i];
		}System.out.println("Sum of all numbers = "+total+"\n\n");
	}
}
class Parallel extends Thread{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		System.out.println("------------------------------");
		PP pp = new PP();
		int a[] = {4, 3, 5, 2};
		pp.sumOfAllNos(a);
		pp.Fibonacci(12);
		Integer A[] = {3, 4, 5};
		pp.reverseList(new ArrayList<Integer>(Arrays.asList(A)) );
		pp.print(6);
	}
}

public class Question3 {

	public static void main(String[] args) {
		System.out.println("3) Create a program which can take input (int) (Ex -10 and display all the numbers below 10 that is 1-9) and preform task - Reverse the list, Fibonacci, Sum of all number \n");
		System.out.println("----------------------------------------------------------------------------------------------------------\n\n");
		Parallel parallel = new Parallel();
		parallel.setName("Par1");
		parallel.start();
		
		Parallel parallel1 = new Parallel();
		parallel1.setName("par2");
		parallel1.setPriority(1);
		parallel.setPriority(2);
		parallel1.start();
		System.out.println("Main ended...");
		
	}

}
