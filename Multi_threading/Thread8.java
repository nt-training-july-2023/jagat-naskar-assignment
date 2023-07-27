package Multi_threading;

public class Thread8 {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("_Thread id_= "+thread.getId());
		try {
			
			thread.sleep(54);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Example example1 = new Example();
		example1.start();
		try {
			example1.sleep(543);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("_Thread name = "+thread.getName());
		System.out.println("_State = "+thread.getState());
		System.out.println("_Status = "+thread.isAlive());
		Example example = new Example();
		example.start();
		

	}

}

class Example extends Thread{
	public void run() {
		print();
	}
	
	public void print() {
		Thread thread = Thread.currentThread();
		System.out.println("Thread id_= "+thread.getId());
		System.out.println("Thread name = "+thread.getName());
		System.out.println("State = "+thread.getState());
		System.out.println("Status = "+thread.isAlive());
	}
}


