package advance.annotation;

import java.util.ArrayList;
import java.util.LinkedList;

public class SpeedTest {

	public static void main(String[] args) {
		TimeRecordProcessor.process(SpeedTest.class);
	}

	@TimeRecord
	public static void ArrayListSpeed() {

		ArrayList<Integer> st = new ArrayList<>();
		for (int i = 0; i < 36000; i++) {
			st.add(i);
		}

		for (int i = 0; i < 24000; i += 2) {
			st.remove(i);
		}
	}

	@TimeRecord
	public static void LinkedListSpeed() {
		LinkedList<Integer> lt = new LinkedList<>();
		for (int i = 0; i < 36000; i++) {
			lt.add(i);
		}

		for (int i = 0; i < 24000; i += 2) {
			lt.remove(i);
		}
	}

}
