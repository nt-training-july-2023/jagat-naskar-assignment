package Multi_threading;

import java.util.Scanner;

public class Question8 {
	public static void main(String args[])
	{
		JoinedAccount j1 = new JoinedAccount();
		JoinedAccount j2 = new JoinedAccount();
		JoinedAccount j3 = new JoinedAccount();
		j1.start();
		j2.start();
		j3.start();
		
	}

}


class JoinedAccount extends Thread{
	static int amount = 90000;
	@Override
	public synchronized void run() {
		System.out.println("Enter withdrawl amount for "+currentThread().getName()+": ");
		Scanner scanner = new Scanner(System.in);
		int w = scanner.nextInt();
		withdraw(w);
	}
	
	public void withdraw(int w) {
		System.out.println("Amount = "+amount);
		System.out.println("Withdrawing amount = "+w);
		amount = amount-w;
		System.out.println("Amount after withdraw = "+amount);
		System.out.println("_________________________________");
	}
	
	
}