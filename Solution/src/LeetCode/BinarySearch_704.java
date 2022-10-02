package LeetCode;

public class BinarySearch_704 {
	public int search(int[] nums, int target) {
		int left = 0; // 0
		int right = nums.length - 1; // 5

		while (left <= right) {
			int pivot = (left + right) / 2; // 1

			if (nums[pivot] == target) { // -1 == 2
				return pivot;
			} else if (nums[pivot] < target) { //
				left = pivot + 1; // 2
			} else {
				right = pivot - 1; // 1
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		BinarySearch_704 search_704 = new BinarySearch_704();

		// int[] nums = {-1, 0, 3, 5, 9, 12};
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 5;

		System.out.println(search_704.search(nums, target));
	}
}
