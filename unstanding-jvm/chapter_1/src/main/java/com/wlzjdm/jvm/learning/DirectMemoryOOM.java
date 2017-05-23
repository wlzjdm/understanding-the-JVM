package com.wlzjdm.jvm.learning;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * VM Args： -Xmx20M -XX:MaxDirectMemorySize=10M</br>
 * JVM可以通过指定-XX:MaxDirectMemorySize指定，如果不指定，那么默认与JAVA堆最大值-Xmx一样。<br>
 * 执行结果：Exception in thread "main" java.lang.OutOfMemoryError
 * @author FDD
 *
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws Exception {
		Field unsaveField = Unsafe.class.getDeclaredFields()[0];
		unsaveField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsaveField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}

}
