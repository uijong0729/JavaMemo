package sort;

import java.util.Arrays;

public abstract class SortManager {
	protected static void print(int[] data) {
		print(Arrays.toString(data));
	}
	protected static void print(int data) {
		System.out.println(data);
	}
	protected static void print(String data) {
		System.out.println(data);
	}
	protected static int[] swap(int[] data, int a, int b) {
		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
		return data;
	}
}
