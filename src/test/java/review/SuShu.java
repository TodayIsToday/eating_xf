package review;
/**
 * 1-100素数
 * @author Administrator
 *
 */
public class SuShu {

	public static void main(String[] args) {
		SuShu su = new SuShu();
		su.sushu();
	}
	
	private void sushu(){
		boolean flg = false;
		for (int i = 2; i <= 100; i++) {
			flg = false;
			for (int j = 2; j <= i/2; j++) {
				if(i%j==0){
					flg = true;
					break;
				}
			}
			if(flg == false){
				System.out.println(i+",");
			}
		}
	}
}
