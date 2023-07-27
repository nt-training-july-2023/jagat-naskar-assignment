package OppsConcept;

public class StaticTesting {
	
	public static void main(String args[]) {
		Hi hi = new Hi();
		//calling static variable by object name
		System.out.println("Schoool = "+hi.school);
		//calling static variable by class name
		System.out.println("School "+Hi.school);
		int a=89, b = 9;
		//calling static function by class name
		System.out.println(a+" + "+b+" = "+Hi.add(a, b));
	}
}

class Hi{
	//static variable
	static String school = "NVPeeth";
	String radio = "RedFM";
	//static block
	static
	{
		//changing static variable's value
		System.out.println("Static block1");
		System.out.println("_____________");
		school = "JKLSchool";
		school = "ABCSchool";
		//radio = "min";// cannot change, since radio is non-staitc variable
		System.out.println("The program will execute this first and then main.");
		
	}
	//static function
	public static int add(int a, int b)
	{
		return (a+b);
	}
	
	
	static {
		System.out.println("Static block2");
		System.out.println("_____________");
		System.out.println("STATIC 2");
	}
}