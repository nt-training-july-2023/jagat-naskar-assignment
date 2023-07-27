package Multi_threading;

public class Question007 extends Thread{

	@Override
	public void run() {
		Message message1 = new Message();
		message1.message();
	}
	
	public static void main(String[] args) {
		System.out.println("Create a Program to set priority of a thread");
		System.out.println("--------------------------------------------");
		
		Question007 question41 = new Question007();
		question41.setName("1st Thread");
		question41.start();
		question41.setPriority(MAX_PRIORITY);
		
		Question007 question42 = new Question007();
		question42.setName("2nd Thread");
		question42.start();
		question42.setPriority(MIN_PRIORITY);
		
		Question007 question43 = new Question007();
		question43.setName("3rd Thread");
		question43.start();
		

	}

}





class Message{
	public void message()
	{
		System.out.println("Thread name = "+Thread.currentThread().getName());
		for(int i = 0; i<5; i++)
		{
			System.out.println(Thread.currentThread().getName()+"---"+i);
			if(i ==2)
				try {
					Thread.sleep(70);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}