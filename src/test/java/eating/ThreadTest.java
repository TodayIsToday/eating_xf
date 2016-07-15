package eating;

public class ThreadTest {

	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// 等待主线程获取锁
					System.out.println(System.currentTimeMillis());
					Thread.sleep(1000);
					System.out.println(System.currentTimeMillis());
					 for (int i = 0; i < 100; i++) {
						 	System.out.println(Thread.currentThread().getName() + " " + i);
							}
					// 请求locker对象的内部锁
				} catch (InterruptedException e) {
					
				}
			}
		},"Blocked Thread");
		thread.start();
		
		
		
	}
}
