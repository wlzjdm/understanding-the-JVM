package com.wlzjdm.jvm.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args： -XX:PermSize=1M -XX:MaxPermSize=1M <br>
 * 说明：此项是配置永久代大小，在JDK1.6及之前，常量是存放于永久代中，所以限制永久代大小就简介限制常量池大小<br>
 * <code>
 *  <b>JDK1.6 Run Result :</b>
 *  <li> 
 *  	Configuration -XX:PermSize=10M -XX:MaxPermSize=10M : 116804 Exception in thread "main" java.lang.OutOfMemoryError: PermGen space <br>
 *  </li>
 *  <li> 
 *  	Configuration -XX:PermSize=20M -XX:MaxPermSize=20M : 280572 Exception in thread "main" java.lang.OutOfMemoryError: PermGen space <br>
 *  </li>
 *  <b>JDK > 1.7 Run Result :</b>
 *  <li> 
 *  	可以一直运行下去
 *  </li>
 *  <b>结论：-XX:PermSize和-XX:MaxPermSzie是配置永久代的大小，在JDK1.6及之前，常量是存放于永久代中，所以可以通过配置永久代大小配置敞亮池，而在JDK1.6之后，逐步剔除永久代的事情。</b>
 * </code>
 * @author FDD
 *
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) throws Throwable {
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		
		try {
			while(true){
				list.add(String.valueOf(i++).intern());
			}
		} catch (Throwable e) {
			System.out.println(list.size());
			throw e;
		}
	}
}
