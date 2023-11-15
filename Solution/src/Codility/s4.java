package Codility;

public class s4 {
	public static void main(String[] args){
		String[] strs1 = {"..XX.X.", "X.X.X.."};
		String[] strs2 = {".XXX…X", "..X.XXXX"};
		String[] strs3 = {"XXXXX", ".X..X"};
		String[] strs4 = {"X…X", "..X.."};
		System.out.println(solve(strs1));
		System.out.println(solve(strs2));
		System.out.println(solve(strs3));
		System.out.println(solve(strs4));
	}

	private static int solve(String[] strs) {
		int l = strs[0].length();
		int sum1 = 0, sum2 = 0;

		for(int i=0;i<l;i++){
			if(strs[0].charAt(i) == 'X')
				sum1++;
			if(strs[1].charAt(i) == 'X')
				sum2++;
		}
		int tmp1 = 0, tmp2 = 0, min = 400000;

		for(int i=0;i<l;i++){
			if(strs[0].charAt(i) == 'X')
				tmp1++;
			if(strs[1].charAt(i) == 'X')
				tmp2++;
			int change = Math.min(tmp1 + sum2 - tmp2 , tmp2 + sum1 - tmp1) + (strs[1].charAt(i) == 'X' ? 1 : 0) + (strs[0].charAt(i) == 'X' ? 1 : 0);
			min = Math.min(min, Math.min(sum1, Math.min(sum2, change)));
		}
		return sum1 + sum2 - min;
	}
}
