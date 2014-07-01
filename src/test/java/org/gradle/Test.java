/**
 * <p>Title: Test.java</p>
 * <p>Description: </p>
 * <p>Copyright: lizhe (c) 2014</p>
 * <p>Company: xiaoma.com</p>
 * @author vincent
 * @date 2014年6月30日
 * @version 1.0
 */
package org.gradle;

/**
 * <p>Title: Test</p>
 * <p>Description: </p>
 * <p>Company: xiaoma.com</p> 
 * @author lizhe
 * @date 2014年6月30日
 */
public class Test {
	public static void main(String[] args) {
		String str = "lizhe, ddddd, ffff,s";
		String[] split = str.split(",");
		for (String string : split) {
			System.out.println(string.trim());
		}
	}
}
