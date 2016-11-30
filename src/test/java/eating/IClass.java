package eating;

import java.lang.reflect.Method;

public class IClass {

	public static void main(String[] args) throws Exception{
		Person person = new Person("hk","12");
		Class clazz = person.getClass();
		Method m1 = clazz.getDeclaredMethod("getName");
		String name = (String)m1.invoke(person);
		System.out.println(name);
		
		Method[] methods = person.getClass().getMethods();
//		for (int i = 0; i < methods.length; i++) {
//			// System.out.println(methods[i]);
//			if(methods[i].getName().equals("getName")){
//				System.out.println(person.getClass().getMethod("getName", person.getClass()));
//			}
//		}
	}

}

class Person {
	String name;
	String age;

	public Person() {}
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}