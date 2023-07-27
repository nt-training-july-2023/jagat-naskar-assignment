package OppsConcept;

public class SingleInheritance {

	public static void main(String[] args) {
		Child child = new Child();
		child.display("Arayan", "Mishra");

	}

}

class Parent{
	String name;
	int age;
}
class Child extends Parent{
	String name;
	String title;
	public void display(String name, String tit) {
		System.out.println("___________________");
		System.out.println("Single Inheritance");
		System.out.println("-------------------");
		System.out.println("My name is "+name);
		System.out.println("My surname is "+tit);
		Parent parent = new Parent();
		parent.name = "Aroma";
		parent.age = 42;
		System.out.println("My parent name is "+parent.name+"and she is "+parent.age+ " years old.");
	}
}
