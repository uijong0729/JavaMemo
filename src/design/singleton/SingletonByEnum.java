package design.singleton;

public enum SingletonByEnum {
	INSTANCE;
	
	public String get() {
		return "name";
	}
}
