package OppsConcept;

public class AbstractClass {

	public static void main(String[] args) {
		Peacock peacock = new Peacock();
		peacock.Print();

	}

}

abstract class Birds{
	abstract void Print();
}

class Peacock extends Birds{
	void Print() {
		System.out.println("Peacock can fly at a certain heights.");
	}
}