package generics;

public class AddingMain {

	public static void main(String[] args) {
		AdditionOfGenerics<String, Integer> objString = new AdditionOfGenerics<String, Integer>("jAGAT", 34);
		System.out.println(objString.aT);
		System.out.println(objString.bQ);
		System.out.println(objString.aT.getClass().getName());
		System.out.println(objString.bQ.getClass().getName());
		objString.concate("Mango", 2);
		
		AdditionOfGenerics<Integer, Integer> objString1 = new AdditionOfGenerics<Integer, Integer>(564, 34);
		System.out.println(objString1.aT);
		System.out.println(objString1.bQ);
		System.out.println(objString1.aT.getClass().getName());
		System.out.println(objString1.bQ.getClass().getName());
		objString1.add(2, 2);
		
		AdditionOfGenerics<String, Integer> objString2 = new AdditionOfGenerics<String, Integer>("j", 34);
		System.out.println(objString2.aT);
		System.out.println(objString2.bQ);
		System.out.println(objString2.aT.getClass().getName());
		System.out.println(objString2.bQ.getClass().getName());
		//objString2.add("j", 2); -> java.lang.NumberFormatException
		objString2.add("2", 2); // this will work, string 2 will convert to numeric 2
	}

}
