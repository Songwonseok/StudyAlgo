package Programmers.toss.test_240427;

public class Solution6_240427 {
	static long answer;
	public long solution(int money, long[][] stocks) {
		answer = 0;

		bruteForce(money, stocks, 0, 0);
		return answer;
	}

	public void bruteForce(int money, long[][] stocks, long acc, int depth) {
		if(depth == stocks.length) {

			answer = Math.max(acc, answer);
			return;
		}


		if(stocks[depth][1] > money) {
			bruteForce(money, stocks, acc, depth + 1);
			return;
		}

		bruteForce(money - (int)stocks[depth][1], stocks, acc + stocks[depth][0], depth + 1);
		bruteForce(money, stocks, acc, depth + 1);
	}

	public static void main(String[] args) {

	}
}
