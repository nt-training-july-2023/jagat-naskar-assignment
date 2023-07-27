package exHandling_javaDocs_Annotation;

import java.util.Scanner;

public class ATM {

	/**
	 * 
	 * @param amt The input field, amount or withdrawing amount
	 * @return The input String value to double
	 * @throws InvalidInputException, if the input value is not positive
	 */
	public static double scanningAmount(String amt) throws InvalidInputException
	{
		double amount=0.0;
		
		try {
			
			
			amount = Double.parseDouble(amt);
			if(amount <= 0)
				throw new InvalidInputException("Amount you have enterd is negativeo or zero");
			
			return amount; 
		}catch (NumberFormatException e) {
			throw new InvalidInputException("Enter positive numeric value");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		double amount=10;
		double wit;
		String amt="77";
		String withdraw;
		Scanner scanner = new Scanner(System.in);
		System.out.println("All good...");
		try {
			System.out.println("-Enter amount: ");
			amt =  scanner.nextLine();
			System.out.println("--Enter withdrawing amount: ");
			withdraw =  scanner.nextLine();
			System.out.println("Amount in string = \'"+amt+"\'");
			System.out.println("Withdrawing in string = \'"+withdraw+"\'");
			amount = scanningAmount(amt);
			wit = scanningAmount(withdraw);
			if(wit>amount)
				throw new InvalidInputException("Enter withdrawing amount < total amount");
			else {
				System.out.println("Success withdrawing!!!");
				System.out.println("Balance = "+(amount-wit));
				amount = amount-wit;
				System.out.println("You amount left in the account = "+amount);
			}
			
			//remainingBalance = scanningRemaining();
		}catch (InvalidInputException e) {
			System.out.println("Error!!!"+e.getMessage());
		}
		 finally {
	            scanner.close();
	        }
		

	}

}
