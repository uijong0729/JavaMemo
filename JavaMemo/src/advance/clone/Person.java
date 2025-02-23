package advance.clone;

import java.util.ArrayList;

public class Person implements Cloneable{
	public int age;
	public String name;
	public ArrayList<String> array = new ArrayList<>();
	
	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person)super.clone();
	}
	
	public static void main(String[] a) throws CloneNotSupportedException {
		Person p = new Person();
		p.age = 1;
		p.name = "name";
		p.array.add("1");
		
		Person p2 = p.clone();
		p2.array.add("2");
		
		System.out.println(p2.age);
		System.out.println(p2.name);
		
		p2.name = "not name";
		System.out.println(p2.name == p.name);
		System.out.println(p.name.equals(p2.name));
		System.out.println(p.array.toString());
		
		
	}
}
