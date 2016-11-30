package com.xinfang.web.eat.util;


/**
 * activiti 学习类
 * @author hk
 *
 */
public class ActivitiUitls {
	public static void main(String[] args) {
		Man man = new Man("hk","23");
		System.out.println(man);
		
		man.setAge("24");
		System.out.println(man);
		Integer.valueOf(null);
	}
}


class Man{
	private String name ;
	private String age;
	
	
	public Man() {
		super();
	}
	public Man(String name, String age) {
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
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}