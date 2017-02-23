package review;

/**
 * 排序
 * @author Administrator
 *
 */
public class MaoPao {

	public static void main(String[] args) {
		MaoPao mp = new MaoPao();
		mp.xuanZe();
		mp.maoPao();
	}
	
	private void maoPao(){
		int[] arr = {222,43,22,44,6,4,89};
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length -i -1; j++) {
				if(arr[j]>arr[j+1]) { // 如果前面的大于后面的
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	private void xuanZe(){
		int[] arr = {222,43,22,44,6,4,89};
		int k = 0;
		int temp = 0;
		for (int i = 0; i < arr.length -1; i++) {
			k = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[k]){
					k = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
