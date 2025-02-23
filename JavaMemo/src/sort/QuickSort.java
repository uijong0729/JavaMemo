package sort;

/*
 * 임의의 값을 하나 선정 : Pivot -> 기준값 
 * 
 * 
 * 
 */
public class QuickSort extends SortManager {
	
	
	public static void main(String[] args) {
		int data[] = { 66, 10, 1, 34, 5, -10, 88, 11, 40 };
		
		sort(data);
		
		print(data);
	}
	
	public static void sort(int[] arr) {
		recursive(arr, 0, arr.length-1);
	}
	
	// 재귀호출 
	public static void recursive(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = partition(arr, start, end);
			recursive(arr, start, pivot-1);
			recursive(arr, pivot, end);
		}
	}
	
	
	public static int partition(int[] arr, int s, int e) {
		for(int pivot = arr[e] ; s <= e ;) {
			while(arr[s] < pivot) s++;
			while(arr[e] > pivot) e--;
			
			if(s <= e) {
				swap(arr, s, e);
				s++;
				e--;
			}
		}
		
		return ((s + e) / 2) + ((s + e) % 2);
	}
	
}
