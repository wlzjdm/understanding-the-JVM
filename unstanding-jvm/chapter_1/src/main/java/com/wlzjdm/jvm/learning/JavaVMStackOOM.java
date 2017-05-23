package com.wlzjdm.jvm.learning;

/**
 * <h1>重要声明：此代码可能导致计算机假死，所以运行前请先保存好自己的工作。</h1>
 * VM Args : -Xss2M
 * @author FDD
 *
 */
public class JavaVMStackOOM {
	/**
	 * 用不停止的方法
	 */
	private void dontStop(){
		while(true){
		}
	}
	
	/**
	 * 马不停蹄的创建进程
	 */
	public void stackLeakByThread(){
		while(true){
			Thread t = new Thread(new Runnable() {
				
				public void run() {
					dontStop();
				}
			});
			
			t.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
		javaVMStackOOM.stackLeakByThread();
	}
}
