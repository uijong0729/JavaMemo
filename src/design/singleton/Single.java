package design.singleton;

import java.util.function.Supplier;

public class Single implements Supplier<Single>{
	private static int count;

	private Single() {
		if (count == 0) {
			count++;
		} else {
			//avoid accessing from a Constructor of the Reflect
			throw new IllegalAccessError("a instance of the Single class must be singleton");
		}
	}

	private static class InstanceHolder {
		private static final Single single = new Single();
	}

	@Override
	public Single get() {
		return InstanceHolder.single;
	}
}
