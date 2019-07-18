package advance.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeRecordProcessor {
	public static void process(Class<?> cla) {
		for (Method m : cla.getMethods()) {
			for (Annotation a : m.getAnnotations()) {
				if (a != null && a.annotationType() == TimeRecord.class) {
					long start = System.currentTimeMillis();
					
					try {
						Constructor con = cla.getConstructor(new Class[] {});
						Object obj = con.newInstance();
						m.invoke(obj, new Object[] {});
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					long end = System.currentTimeMillis();
					System.out.println("�共嵂� �亨�ｰ� : " + (end - start));
				}
			}
		}
	}
}
