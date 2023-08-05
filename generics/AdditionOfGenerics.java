package generics;

public class AdditionOfGenerics <T, Q>{
	T aT;
	Q bQ;
	
	AdditionOfGenerics(T aT, Q bQ) {
		this.aT = aT;
		this.bQ = bQ;
	}
	public Object getValue()
	{
		return this.aT;
	}
	public void concate(T aT, Q bQ) {
		System.out.println("concatination of "+(aT)+" and "+(bQ));
		System.out.println("-----------------------------------");
		System.out.println(aT.toString()+bQ.toString());

	}
	public void add(T aT, Q bQ) {
		System.out.println("Addition of "+(aT)+" and "+(bQ));
		String k = bQ.toString();
		String k1 = aT.toString();
		System.out.println("Addition");
		System.out.println("________");
		System.out.println(Integer.parseInt(k)+Integer.parseInt(k1));

	}
	
}
