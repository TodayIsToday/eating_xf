package com.xinfang.web.eat.util;


import org.joda.time.DateTime;

public class Stringdd {

	public static final String[] arrys = { "personUuid", "name", "photo", "gender", "birthday", "idType", "idNumber",
			"nation", "mobile", "telephone", "companyName", "jobId", "email", "userId", "contactProvinceCode",
			"contactDistrictCode", "contactStreetCode", "contactAddressDetail", "contactZipCode", "addressProvinceCode",
			"addressDistrictCode", "addressStreetCode", "addressDetail", "addressZipCode", "domicileProvinceCode",
			"domicileDistrictCode", "domicileStreetCode", "domicileAddressDetail", "domicileZipCode", "deathFlg" };

	public static void main(String[] args) throws Exception {
		String timeTest = "2015/01/21 23:13:23";
		DateTime test = DateTime.parse(timeTest);
		System.out.println(test);
		
	}
	public static String getPara(String pot) {
		String pre = "get";
		String upCase = pot.substring(0,1).toUpperCase();
		String methodStr = pre + upCase + pot.substring(1,pot.length());
		return methodStr;
	}
}

class A {

	private String name;
	private String salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}