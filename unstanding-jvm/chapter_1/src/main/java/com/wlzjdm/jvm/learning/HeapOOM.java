package com.wlzjdm.jvm.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author FDD
 *
 */
public class HeapOOM {
	static class HeapObject{
		
	}
	
	public static void main(String[] args) {
		List<HeapObject> list = new ArrayList<HeapObject>();
		while(true){
			list.add(new HeapObject());
		}
	}
}
