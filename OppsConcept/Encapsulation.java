package OppsConcept;

public class Encapsulation {

	public static void main(String[] args) {
		System.out.println("              Encapsulation");
		System.out.println("------------------------------------------");
		Animal rabbit = new Animal();
		rabbit.setHeight(29);
		rabbit.setHearingCapability(60);
		System.out.println("Height of the Rabbit = "+rabbit.getHeight()+"cm");
		System.out.println("Hearing capability  of Rabbit = "+rabbit.getHearingCapability()+"Hz");

	}

}

class Animal{

	private int height;
	private int hearingCapability;
	//constructor
	
	
	//getters and setters
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHearingCapability() {
		return hearingCapability;
	}
	public void setHearingCapability(int hearingCapability) {
		this.hearingCapability = hearingCapability;
	}
	
	
}