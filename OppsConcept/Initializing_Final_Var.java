package OppsConcept;

public class Initializing_Final_Var {
	//final variable a
	final int a = 23;
	//cannot re-initialize
	//a =43;
	//final var b which is not initialize yet
	final int b;
	//b will be initialize in constructor
	public Initializing_Final_Var(int k) {
		b=k;
	}
	public static void main(String[] args) {
		Initializing_Final_Var objFinal_Var = new Initializing_Final_Var(343);
		System.err.println("Value of final var \'a\' which is directly initialize = "+objFinal_Var.a);
		System.err.println("Value of final bar b which is initialize in constructor = "+objFinal_Var.b);

	}

}
