package OppsConcept;

public class multiLevelInheritance {
	//main method
	public static void main(String[] args) {
		
		C object=new C();  
		object.eat();  
		object.play();  
		object.swim(); 
	}

}



//Parent class
class A{  
	void eat(){
		System.out.println("A is eating Sandwich.");
		}  
}  
//Parent class of C but child of A
class B extends A{  
	void play(){
		System.out.println("B is playing basketball");
		}  
}  
//child class of B and not married
class C extends B{  
	void swim(){
		System.out.println("C is swiming in the swiming-pool.");}  
}  
