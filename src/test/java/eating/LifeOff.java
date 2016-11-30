package eating;

/**
 * 线程学习 计时器
 * @author hk
 *
 */
public class LifeOff implements Runnable{

	protected int countDown = 10; // Default
	private static int taskcount;
	private final int id = taskcount ++;
	
	public LifeOff() {}

	public LifeOff(int countDown) {
		this.countDown = countDown;
	}

	public String status(){
		return "#" + id + "(" + "" + 
				(countDown >0 ? countDown : "life off") + ")";
	}
	
	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LifeOff()).start();
		}
	}

}
