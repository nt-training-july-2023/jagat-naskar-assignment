package OppsConcept;

public class AnonymousInner {

	  public static void main(String[] args) {
		  AnonymousInner outerClass = new AnonymousInner();

	        // Create an anonymous inner class
	        outerClass.KALKI(new DISPLAY() {
	            @Override
	            public void display() {
	                System.out.println("First time overiding display().");
	            }
	        });

	     
	        
	        
	        // Create 2nd anonymous inner class
	        outerClass.KALKI(new DISPLAY() {
	            @Override
	            public void display() {
	                System.out.println("2nd time displaying display()");
	            }
	        });
	        
	        
	        // Create 3rd anonymous inner class
	        outerClass.KALKI(new DISPLAY() {
	            @Override
	            public void display() {
	                System.out.println("3nd time displaying display()");
	            }
	        });
	        
	        
	        
	    }

	  
	    public void KALKI(DISPLAY d) {
	        // method which will be overridden in anonymous inner class
	        d.display();
	    }

	    //an interface
	    interface DISPLAY {
	        void display();
	    }
}





