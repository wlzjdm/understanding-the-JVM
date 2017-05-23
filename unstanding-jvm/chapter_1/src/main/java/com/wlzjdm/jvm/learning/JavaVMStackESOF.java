package com.wlzjdm.jvm.learning;

/**
 * VM Args: -Xss128K
 * 模拟测试本地方法栈溢出情况，抛出：java.lang.StackOverflowError<br>
 * <ul>
 * 配置为：-Xss1K时，stack大小为19015
 * </ul>
 * <ul>
 * 配置为：-Xss2K时，stack大小为18434
 * </ul>
 * <ul>
 * 配置为：-Xss128K时，stack大小为987
 * </ul>
 * <ul>
 * 配置为：-Xss512K时，stack大小为8486
 * </ul>
 * <ul>
 * 配置为：-Xss1M时，      stack大小为19264
 * </ul>
 * <ul>
 * 配置为：-Xss20M时，   stack大小为1270590
 * </ul>
 * <b>结论：</b>
 * <li>
 * -Xss用于配置本地方法栈大小
 * </li>
 * <li>
 * 栈是方法区使用的，很容易理解，一般一个方法都是后进先出的。
 * </li>
 * @author FDD
 *
 */
public class JavaVMStackESOF {
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackESOF javaVMStackESOF = new JavaVMStackESOF();
		try {
			javaVMStackESOF.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack Length is :" + javaVMStackESOF.stackLength);
			throw e;
		}
	}
}
