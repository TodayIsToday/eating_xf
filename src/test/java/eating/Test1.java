package eating;

public class Test1 {

	public static void main(String[] args) {
		String url = "/xinfang-staff/mywork/inboxTodoList";
		String[] strArr = url.split("/");
		
		System.out.println(strArr[2]);
	}
}
