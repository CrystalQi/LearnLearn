package Facebook;

public class SwapMaxArray {
	public static void swapMaxArray(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int idx = 1;
		while (idx < arr.length) {
			if (arr[idx - 1] < arr[idx]) {
				break;
			}
			++idx;
		}
		if (idx == arr.length) {
			return;
		}
		int maxIdx = idx;
		++idx;
		while (idx < arr.length) {
			if (arr[idx] >= arr[maxIdx]) {
				maxIdx = idx;
			}
			++idx;
		}
		
		idx = 0;
		while (idx < arr.length) {
			if (arr[idx] < arr[maxIdx]) {
				int tmp = arr[maxIdx];
				arr[maxIdx] = arr[idx];
				arr[idx] = tmp;
				return;
			}
			++idx;
		}
	}

	public static void main(String [] args) {
		int[] arr1 = new int[]{5,4,3,2,1};
		int[] arr2 = new int[]{5,3,2,1,5};
		int[] arr3 = new int[]{5,4,2,1,4};
		
		swapMaxArray(arr1);
		swapMaxArray(arr2);
		swapMaxArray(arr3);
		
		for (int i = 0; i < arr1.length; ++i) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		

		for (int i = 0; i < arr2.length; ++i) {
			System.out.print(arr2[i]);
		}
		System.out.println();

		for (int i = 0; i < arr3.length; ++i) {
			System.out.print(arr3[i]);
		}
		System.out.println();
	}
}

