package OppsConcept;

import java.io.NotActiveException;

public class StaticClass {

	public static void main(String[] args) {
		// display method of inner static class can be called without method.
		//OuterClass.InnerStaticClass.display();
		OuterClass.InnerStaticClass objClass = new OppsConcept.OuterClass.InnerStaticClass();
		
		objClass.addition();
		//no instanc is created for static inner method
		OuterClass.InnerStaticClass.tripple_addition();
		

	}

}







 class OuterClass{  
	  static int a=30;  
	  static int b =43;
	  int c = 4;
	  int d = 54;
	  static class InnerStaticClass{  
		  int k = 43;
		  int m =43;
		  static int p = 432;
		  
		  //non-static method in static inner class
		   void addition(){
			   System.out.println("a+b = "+(a+b));
			   System.out.println("k.inner_non-static + m.inner_non-static = "+(k+m));
			   //outer static and non satic will not add in static class
			   //System.out.println(a+c);
			   System.out.println("a.outer_static + k.inner_non-static = "+a+k);
			   //outer non-static and inner non-static will not add in static class
			   //System.out.println(d+k);
			   System.out.println("p.inner_static + m.inner_non-static = "+p+m);
			   System.out.println("________________________________________\n\n\n");
			   }  
		   //static method in static inner class
		   static void tripple_addition() {
			   //only static variable will work from outer and inner class
			   System.out.println("a+b+p = "+(a+p+b));
			   //non-static variable will not work
			   //System.out.println("k.inner_non-static + m.inner_non-static = "+(k+m));
			   //outer static and non satic will not add in static class
			  // System.out.println(a+c);
			  //not work
			   //System.out.println("a.outer_static + k.inner_non-static = "+a+k);
			   //outer non-static and inner non-static will not add in static class
			  // System.out.println(d+k);
			   //not work in static function
			   //System.out.println("p.inner_static + m.inner_non-static = "+p+m);
			   System.out.println("________________________________________\n\n\n");
		   }
	  }  
	  
	 
	}  

