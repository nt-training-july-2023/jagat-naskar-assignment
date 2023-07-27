package Multi_threading;



public class Question2 extends Thread{


	
	int i = 0;
		@Override
		public void run()
		{
			
			System.out.println("run....("+(i++)+")....");
			for(int i = 0; i<23; i++) {
				System.out.print(i+", ");
				System.out.println("current thread = "+currentThread().getName());
				if(i==9)
					try {
						sleep(45);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}System.out.println();
			
		}
	
	public static void main(String[] args) {
		System.out.println(" Create a program where you check running threads (should be 3 Threads and more)");
		System.out.println("_______________________________________________________________________\n");
		
		System.out.println("A class implements runnable");
		A aClass = new A();
		try {
			Thread thread = new Thread(aClass);
			thread.setName("aClassssss");
			thread.start();
		}catch (IllegalThreadStateException e) {
			System.out.println("Illegal = "+e.getMessage());
		}
			
		
		System.out.println("obj1 created");
		Question2 question2 = new Question2();
		question2.setName("Q2_________");
		question2.start();
		Question2 question22 = new Question2();
		question22.setName("Q222222222222222");
		System.out.println("obj2 created");
		question22.start();
		try {
			sleep(45);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println();	
		
		System.out.println("End of Main.");
	
	}

}

class A implements Runnable{
	@Override
	public void run() {
		System.out.println("Inside runnable interface.");
	}
}
