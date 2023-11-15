package Codility;

public class Solution3 {
	public int solution(String L1, String L2) {
		// 무조건 한줄 비워야함
		int length = L1.length();

		int totalL1 = 0;
		int totalL2 = 0;

		for(int i = 0; i < length; i++) {
			if (L1.charAt(i) == 'x') {
				totalL1++;
			}

			if (L2.charAt(i) == 'x') {
				totalL2++;
			}
		}

		int offsetL1 = 0;
		int offsetL2 = 0;
		// int min = 400000;
		int min = Math.min(totalL1, totalL2);

		for (int i = 0; i < length; i++) {
			int currPath = 0;

			if (L1.charAt(i) == 'x') {
				offsetL1++;
				currPath++;
			}

			if (L2.charAt(i) == 'x') {
				offsetL2++;
				currPath++;
			}

			// A | B
			// B | A
			// A + B
			int exclude = Math.min(offsetL1 + totalL2 - offsetL2 , offsetL2 + totalL1 - offsetL1) + currPath;
			// min = Math.min(min, Math.min(totalL1, Math.min(totalL2, exclude)));
			min = Math.min(min, exclude);
		}

		return totalL1 + totalL2 - min;
	}


	public static void main(String[] args) {

	}
}

	// private static int PathHole(string L1, string L2)
	// {
	// 	int l = L1.Length;
	// 	int countL1 = 0, countL2 = 0;
	// 	for (int i = 0; i < l; i++)
	// 	{
	// 		if (L1[i] == 'X')
	// 			countL1++;
	// 		if (L2[i] == 'X')
	// 			countL2++;
	// 	}
	// 	int emptyL1 = 0, emptyL2 = 0, min = Int32.MaxValue;
	// 	for (int i = 0; i < l; i++)
	// 	{
	// 		if (L1[i] == 'X')
	// 			emptyL1++;
	// 		if (L2[i] == 'X')
	// 			emptyL2++;
	// 		int change = Math.Min(emptyL1 + countL2 - emptyL2, emptyL2 + countL1 - emptyL1) + (L2[i] == 'X' ? 1 : 0) + (L1[i] == 'X' ? 1 : 0);
	// 		min = Math.Min(min, Math.Min(countL1, Math.Min(countL2, change)));
	// 	}
	// 	return countL1 + countL2 - min;
	// }
