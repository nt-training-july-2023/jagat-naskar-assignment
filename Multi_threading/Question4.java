package Multi_threading;

public class Question4 extends Thread{
	@Override
	public void run() {
		Message message1 = new Message();
		message1.message();
	}
	public static void main(String[] args) {
		System.out.println("Create a Program where Threads are reading a "
				+ "message and giving acknowlegement (What a particular "
				+ "thread is reading)");
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		Question4 question41 = new Question4();
		question41.setName("1st Thread");
		question41.start();
		
		Question4 question42 = new Question4();
		question42.setName("2nd Thread");
		question42.start();
		
		Question4 question43 = new Question4();
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