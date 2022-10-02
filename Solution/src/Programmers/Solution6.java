package Programmers;

public class Solution6 {
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		int dist = Math.abs(r - x) + Math.abs(c - y);

		if(dist < k || (k - dist) % 2 == 1) {
			return "impossible";
		}

		StringBuilder sb = new StringBuilder();

		char[] dir = {'d', 'l', 'r', 'u'};


		int height = r - x; // 아래 있으면 + , 위에 있으면 -
		int width = c - y; // 우측에 있으면 +, 좌측에 있으면 -


		while(k - Math.abs(width) > 0 && Math.abs(height) + Math.abs(width) <= k) {

			if(x + 1 <= n) {
				height--;
				x++;
				sb.append('d');
			}
			break;
		}

		while(k - Math.abs(height) > 0 && Math.abs(height) + Math.abs(width) < k) {

			if(y - 1 >= 1) {
				width++;
				y--;
				sb.append('l');
			}
			break;
		}

		sb.append("r".repeat(Math.abs(width)));
		sb.append("u".repeat(Math.abs(height)));

		return sb.toString();
	}
}
