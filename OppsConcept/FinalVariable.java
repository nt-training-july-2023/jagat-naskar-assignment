package OppsConcept;

public class FinalVariable {

	public static void main(String[] args) {
		Children c1 = new Children();
		c1.name = "Arup";
		c1.age = 15;
		System.out.println("Name = "+c1.name+", Age = "+c1.age+", school = "+c1.school_name);
		Children c2 = new Children();
		c2.name = "Rohit";
		c2.age = 16;
		//child c1 and c2 have same school name
		System.out.println("Name = "+c2.name+", Age = "+c2.age+", school = "+c2.school_name);
		//school name cannot be changed, will give error
		//c2.school_name = "fdsf";

	}

}


class Children{
	final String school_name = "MNP School";
	String name;
	int age;
}
