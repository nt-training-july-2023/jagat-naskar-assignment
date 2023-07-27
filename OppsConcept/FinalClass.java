package OppsConcept;

public class FinalClass {

	public static void main(String[] args) {
		Bg b= new Bg();
		b.m();
		
		//final class object
		Password password = new Password();
		password.print();

	}

}


class Animal{
	int k =22;
	final void no_ofLegs() {
		System.out.println("I have "+k+" legs.");
	}
}

final class Password extends Animal{
	int k =4;
	//cannnot be override the final method
	/*
	void no_ofLegs("I have "+k+" legs.")
	{
		System.out.println();
	}*/
	
	
	String s= "234";
	void print() {
		System.out.println("I am in final class's method.");
	}
}
/*
 //extending Password class is not possible, since it is final class
class GK extends Password{
	void print() {
		System.out.println("I am in GK class and overriding final class's method.");
}
*/

class Bg {
	Password objPassword = new Password();
	void m() {
		System.out.println(objPassword.s);
	}
}
