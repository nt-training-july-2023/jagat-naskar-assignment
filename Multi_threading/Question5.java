package Multi_threading;

public class Question5 {
    public static void main(String[] args) throws InterruptedException {
       
        AA thread = new AA();
        AA thread2 = new AA();
        System.out.println(thread.getName() +"->Thread state after creation: " + thread.getState());
        System.out.println(thread2.getName() +"->Thread state after creation: " + thread2.getState());

        thread.start();
        thread2.start();
        //  after starting
        System.out.println(thread.getName() +"->Thread state after starting: " + thread.getState());
        System.out.println(thread2.getName() +"->Thread state after starting: " + thread2.getState());
      
        
        
      //running state to waiting state
		thread2.wait();
		
		System.out.println(thread2.getName()+" __  "+thread2.getState());
	    thread2.notify();
	    System.out.println(thread2.getName()+" __ "+ thread2.getState());
        
        
        
        // Wait for the thread to complete
        try {
            thread.join();
            System.out.println(thread.getName() +"->__"+thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final state of the thread after completing its task
        System.out.println(thread.getName() +"->Thread state after completion: " + thread.getState());
        
        for(int i=0; i<4; i++) {
        	System.out.println(Thread.currentThread().getName()+" : "+i+Thread.currentThread().getState());
        }
        System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getState());
        
    }
}


class AA extends Thread{
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(currentThread().getName() +"->--"+currentThread().getState());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}