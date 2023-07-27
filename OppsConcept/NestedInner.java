package OppsConcept;


import JavaPrograms.ABC;

public class NestedInner {

	public static void main(String[] args) {
		Ak aaA = new Ak();
		System.out.println("a from A class object = "+aaA.a);
		System.out.println("----------1--------------------");
		
		Ak.Bk f = aaA.new Bk();
		System.out.println(f.b);
		System.out.println("----------2--------------------");
		//System.out.println(f.display());
		f.display();
		System.out.println("----------3--------------------");
	
		

	}

}

class Ak{
	int a = 10;
	public boolean abc()
	{
		System.out.println("fsdgfsd");
		
		@SuppressWarnings("unused")
		class insideMethodABCofAk{
			public void mm()
			{
				System.out.println("-----I am inside Ak's method.-----");
			}
		}
		insideMethodABCofAk j = new insideMethodABCofAk();
		j.mm();
		return true;
		
	}
	class Bk{
		int b=8;
		
		//gA.abc();
		public void display()
		{
			Ak objAk = new Ak();
			System.out.println("_______________________");
			System.out.println("CAlling A's method in B");
			System.out.println(abc());
			
			System.out.println("_______________________");
			System.out.println("value of a from class Ak = "+a);
			System.out.println("value of b from inner class Bk"+b);
		}
		
	}
}