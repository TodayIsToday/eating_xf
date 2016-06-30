package eating;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		Set<Test> myList = new HashSet<Test>();
		
		Test t1 = new Test("hk5");
		myList.add(t1);
		myList.add(new Test("hk1"));
		myList.add(new Test("hk2"));
		myList.add(new Test("hk3"));
		myList.add(new Test("hk4"));

		
		
		

		System.out.println(myList);
	}
}
class Test{
	public String name;

	public Test(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [name=" + name + "]";
	}

	
	
	
}