package design.callback;

import advance.clone.Person;
import design.callback.PersonMaker.Callback;

public class PersonMaker {
	static interface Callback{
		void execute(Person p);
	}
	public static Person makePerson(Callback callback) {
		Person p = new Person();
		callback.execute(p);
		return p;
	}
}

class PersonShop{
	public static void main(String[] args) {
		
		//original
		PersonMaker.makePerson(new Callback() {
			@Override
			public void execute(Person p) {
				System.out.println(p);
			}
		});
		
		//advanced
		PersonMaker.makePerson((p)->{
			System.out.println(p);
		});
		
		//more advanced
		PersonMaker.makePerson(System.out::println);
	}
}