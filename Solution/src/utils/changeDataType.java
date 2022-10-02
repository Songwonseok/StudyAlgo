package utils;

public class changeDataType {

	public static String change(String data) {
		return data.replace("[","{").replace("]", "}");
	}
	public static void main(String[] args) {
		//프로그래머스 입력값
		String data = "[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]";
		System.out.println(change(data));
		
	}

}
