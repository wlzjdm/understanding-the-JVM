package com.wlzjdm.jvm.learning;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args : -XX:PermSize=10M -XX:MaxPermSize=10M <br>
 * 此例用来模拟方法区异常，
 * 结果：OutOfMemoryError: PermGen space
 * @author FDD
 *
 */
public class JavaMethodAreaOOM {
	public static void main(String[] args) throws Exception {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {

				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invoke(obj, args);
				}
			});
			enhancer.create();
		}
	}

	static class OOMObject {
		public OOMObject() {
		}
	}
}
