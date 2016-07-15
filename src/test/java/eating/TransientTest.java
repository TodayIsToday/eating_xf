package eating;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Transient关键字测试
 * 如果一个对象没有实现Serializable接口他是不能被反序列话的
 * @author hk
 *
 */
public class TransientTest {

	public static void main(String[] args) throws IOException {

		User user = new User("hk", "y&mtF1992");
		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getName());
		System.err.println("password: " + user.getPassword());

		/**
		 * 输出文件
		 */
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("d:/test.txt"));
			os.writeObject(user);
			os.flush();
			os.close();

		} catch (Exception e) {
			throw new IOException("not find file");
		}
		/**
		 * 读取文件
		 */
		try {

			ObjectInputStream oi = new ObjectInputStream(new FileInputStream("d:/test.txt"));
			User userIn = (User) oi.readObject();
			oi.close();

			System.out.println("read before Serializable: ");
			System.out.println("username: " + userIn.getName());
			System.err.println("password: " + userIn.getPassword());
		} catch (Exception e) {
			throw new IOException("not find file");
		}

	}

}

/**
 * User bean
 * 
 * @author hk
 *
 */
class User implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;
	transient String password;

	public User(String name, String password) {
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
