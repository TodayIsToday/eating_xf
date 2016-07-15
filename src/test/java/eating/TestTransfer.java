package eating;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.测试序列化 
 * 2.线程  
 * 3.网络传输
 * @author hk
 *
 */
public class TestTransfer {

	public static void main(String[] args) {
		new MyServer().start();
		new MyClient().start();
		
	}
}

/**
 * 客户端反序列化对象
 */

class MyClient extends Thread{
	
	public void run(){
		try {
			
			Socket sot = new Socket("localhost", 9999);
			ObjectInputStream  os = new ObjectInputStream(sot.getInputStream());
			User1 user1 = (User1)os.readObject();
			System.out.println("threadName:"+Thread.currentThread() + user1.getName()+"\n"+user1.getPassword());
			sot.close();
			os.close();
		} catch (Exception e) {
			System.err.println("error");
		}
	}
}
/**
 * 客户端序列化对象
 */
class MyServer extends Thread{
	
	public void run(){
		try {
			ServerSocket ss = new ServerSocket(9999);
			Socket st = ss.accept();
			ObjectOutputStream ops = new ObjectOutputStream(st.getOutputStream());
			User1 user1 = new User1("threadName:"+Thread.currentThread() +"\n" + "hk", "123");
			ops.writeObject(user1);
			ops.flush();
			ops.close();
			st.close();
			ss.close();
			
		} catch (Exception e) {
			System.err.println("error");
		}
	}
}


/**
 * user bean
 * @author hk
 *
 */
class User1 implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;
	String password;

	public User1(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

}
