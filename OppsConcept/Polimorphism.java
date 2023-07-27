package OppsConcept;

public class Polimorphism {

	//Method overriding
	//method with 2 arguments
	public void Dianosaur(int a, String name) {
		System.out.println("Hi, I am "+name+" I have "+a+" legs and don't have a horn");
	}
	//same method with 3 arguments
	public void Dianosaur(int a, int b, String name) {
		System.out.println("Hi, I am "+name+" I have "+a+" legs and "+b+" horn");
	}
	//main method in Polimorphism class
	public static void main(String[] args) {
		System.out.println("Practising Polimorphism(Method overloading)");
		System.out.println("------------------------------------------");
		Polimorphism polimorphism = new Polimorphism();
		polimorphism.Dianosaur(2, "Theropods");
		polimorphism.Dianosaur(4, 1, "Carnotaurus");
		
		System.out.println("\n\n\n\n\n");
		System.out.println("------------------------------------------");
		System.out.println("Practising Polimorphism(Method overriding)");
		System.out.println("------------------------------------------");
		System.out.println();
		//calling parent class
		System.out.println("calling parent class");
		Shapes shapes = new Shapes();
		shapes.sides(0);
		System.out.println();
		System.out.println("---------1-------------");
		//calling child class
		System.out.println("calling child class");
		Triangle triangle = new Triangle();
		triangle.sides(3);
		System.out.println("----------2------------");
		System.out.println();
		triangle.childClass();
	}
}


class Shapes{
	
	public void sides(int a)
	{
		System.out.println("Differnet types of sides will be available in diferent shapes.");
	}
}


class Triangle extends Shapes{
	public void sides(int a)
	{
		System.out.println("I have "+a+" sides, since i am a trianble");
	}
	public void childClass() {
		System.out.println("I am child class calling a similar methods(which i have one) from my parents usig super key.");
		System.out.println("______Parents method using super-key______");
		super.sides(0);
		System.out.println("_________End of my Parents method_________");
	}
	
}
