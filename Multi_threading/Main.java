package Multi_threading;


public class Main extends Thread {
	  public static int amount = 0;

	  public static void main(String[] args) {
	    Main thread = new Main();
	    System.out.println(amount);
	    
	    thread.start();
	    System.out.println(amount);
	    try{
	    	sleep(59);
	        }catch(Exception e){
	          System.out.println(e.getMessage());
	        }
	    amount++;
	    System.out.println(amount);
	  }

	  public void run() {
	  	System.out.println("Thread");
	    amount++;
	    System.out.println("amount ="+amount);
	    System.out.println("Thread end");
	  }
	}
