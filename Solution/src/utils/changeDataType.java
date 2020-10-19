package utils;

public class changeDataType {

	public static String change(String data) {
		return data.replace("[","{").replace("]", "}");
	}
	public static void main(String[] args) {
		//프로그래머스 입력값
		String data = "[[1, 1, 0], [1, 1, 0], [0, 0, 1]]";
		System.out.println(change(data));
		
	}

}
