package eating;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举遍历测试
 * @author hk
 *
 */
public class EnumTest {
	
	public enum Type{
		Test1(1),
		Test2(2);
		
		public final int TYPE_CODE;
		private static Map<Integer,Type> codeLookup = new HashMap<Integer,Type>();
		
		
		static{
			for (Type type : Type.values()) {
				codeLookup.put(type.TYPE_CODE, type);
			}
		}
		
		Type(int code) {
			this.TYPE_CODE = code;
		}
		
		public static Type forCode(int code){
			return codeLookup.get(code);
		}
	}
	
	
	public static void main(String[] args) {
		Type tets = Type.forCode(1);
		System.out.println(tets.Test1.TYPE_CODE);
	}
	
}

