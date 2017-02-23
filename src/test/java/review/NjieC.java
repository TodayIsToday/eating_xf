package review;

/**
 * 阶乘
 * @author Administrator
 *
 */
public class NjieC {

	public static void main(String[] args) {
//		int n = 5;
//		int sum = 1;
//		for (; n >0; n--) {
//			sum *= n;
//		}
//		System.out.println(sum);
		
//		System.out.println(secsion(5));
		
		
//		int i = 1;
//		if(i==1 &&(1==1 || 1==3)){
//			System.out.println("sdfas");
//		}else{
//			System.out.println("aaa");
//		}
		
		
	}
	
	public static int secsion(int n){
		
		if(n == 1)
			return 1;
		else 
			return n * secsion(n - 1);
	}
}
