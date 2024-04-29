package Programmers.toss.test_240427;

public class Solution5_240427 {
	public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// orderAmount : 주문금액
		// taxFreeAmount : 비과세금액
		// serviceFee : 봉사료

		// 과세금액 = (10*주문금액 - 10*봉사료 + 비과세) / 9 + 비과세
		// 부가가치세 = 과세금액 / 10; 소수점 첫재짜리 올림

		if(orderAmount - serviceFee == 1) {
			return 0;
		}

		return (long)Math.ceil(((10*orderAmount - 10*serviceFee + taxFreeAmount) / 11  + taxFreeAmount) / 10);
	}
}
