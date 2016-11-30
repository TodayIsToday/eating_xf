package com.xinfang.web.eat.util;

public class TransferTest {

	public static <T> MergeCell test(MergerTransfer<T> mergerTransfer) {
		MergeCell cell = new MergeCell();
		mergerTransfer.trasfer2Cell(cell);
		System.out.println(cell);
		return null;
	}

	public static interface MergerTransfer<T> {

		void trasfer2Cell(MergeCell cell);

	}

	public static <T> void main(String[] args) {
		TransferTest.test(new MergerTransfer<T>() {

			@Override
			public void trasfer2Cell(MergeCell cell) {

				cell.setName("hk");
				cell.setAge("18");
			}
		});
	}
}

class MergeCell {

	private String name;

	private String age;

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
		return "MergeCell [name=" + name + ", age=" + age + "]";
	}

}