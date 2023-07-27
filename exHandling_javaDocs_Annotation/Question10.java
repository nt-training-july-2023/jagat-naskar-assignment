package exHandling_javaDocs_Annotation;

import java.util.Scanner;

public class Question10 {

	public static void main(String[] args) {
		Password password = new Password();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Password: ");
		String s= scanner.next();
		password.checkPAssword(s);

	}

	
}


class Password{
	public boolean BothLettersNum(String s) {
		int ch=0, num = 0;
		 for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) < '0' || s.charAt(i) > '9')
	            	ch++;
	            else num++;
	            }
		 
		 if(ch == 0 || num == 0)
			 return false;
		 else return true;
	}
	 public void checkPAssword(String s) {
		 try {
			 if(s.length() >=8 && BothLettersNum(s)) {
				 System.out.println("Your PAssword is correct...");
			 }
			 else {
				throw new InvalidPasswordException("InvalidPasswordException- Password shoud be >=8 and alpha-num");
			}
		 }catch (InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
	 }
}