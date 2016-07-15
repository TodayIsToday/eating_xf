package eating;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 正则替换
 * @author hk
 *
 */
public class Patter {

	public static void main(String[] args) {
		String str = "中共上海市(信访办)";
		
//		Pattern patt = Pattern.compile("市");
//		Matcher mat = patt.matcher(str);
//		int startReg = 0;
//				mat.find();
//		String tets = str.substring(0, startReg);
		
		int length = str.length();
		int reg = str.indexOf("(");
		String test = str.substring(0, reg);
		System.out.println(test);
		
	}
}
