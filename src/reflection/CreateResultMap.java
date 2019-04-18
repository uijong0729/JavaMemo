package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;

import test.TestClass;

public class CreateResultMap {
	private final String pack = "test.TestClass";

	public String getFields(String jdbcType){
		StringBuffer sb = new StringBuffer();
		try {
			Class<?> c = Class.forName(pack);
			Field[] field = c.getDeclaredFields();
			for(Field f : field) {
				String name = f.getName();
				sb.append("<result property=\"");
				sb.append(name+"\"");
				sb.append(" jdbcType=\""+ jdbcType +"\"");
				sb.append(" column=\"" + convertField(name) + "\">");
				sb.append("\n");
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private String convertField(String str) {
		StringBuffer sb = new StringBuffer();
		char[] list = str.toCharArray();
		for(int i = 0 ; i < list.length ; i++) {
			if(Character.isUpperCase(list[i])) {
				sb.append("_");
				sb.append(Character.toLowerCase(list[i]));
			}else {
				sb.append(list[i]);
			}
		}
		return sb.toString();
	}
	
}
