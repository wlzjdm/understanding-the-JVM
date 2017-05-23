package com.wlzjdm.jvm.learning;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * VM args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 模拟内存溢出情况，抛出：java.lang.OutOfMemoryError: Java heap space
 * 当配置为：[-Xms20m -Xmx20m]时，执行信息：Heap dump file created [27931458 bytes in 0.604 secs]，内存中存放了：810325个对象
 * 当配置为：[-Xms10m -Xmx10m]时，执行信息：Heap dump file created [13075518 bytes in 0.261 secs]，内存中存放了：360145个对象
 * 分析.hprof工具为：MemoryAnalyzer
 * 结论：
 * <li>
 * 通过配置-Xms参数设置堆最小值，通过-Xmx设置堆最大值，当堆使用大于最大值得时候就会抛出OutOfMemoryError。
 * </li>
 * <li>
 * 堆是用于存储内存对象的，当我们写代码的时候，生成的每一个对象都会放在堆中。
 * </li>
 * @author FDD
 *
 */
public class HeapOOM {
	static class HeapObject implements Serializable{
		
	}
	
	public static void main(String[] args) throws Exception {
		List<HeapObject> list = new ArrayList<HeapObject>();
		try {
			//计算一个对象大小。按照序列化方式计算
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			oos.writeObject(new HeapObject());
//			System.out.println(bos.toByteArray().length);
//			oos.close();
//			bos.close();
			while(true){
				list.add(new HeapObject());
			}
		} catch (Throwable e) {
			System.out.println("List size is :" + list.size());
			e.printStackTrace();
		}
	}
}
