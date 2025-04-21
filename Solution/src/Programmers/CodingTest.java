package Programmers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CodingTest {

	public static void main(String[] args) {

		List<A> list = new ArrayList<>();
		String binary = toVarBinary("20Xsd");

		System.out.println(binary);
		System.out.println(fromVarBinary(binary));


		list.add(new A("abc"));
		list.add(new A("abc"));
		list.add(new A("abc"));
		list.add(new A("abc"));
		list.add(new A("abc"));
		list.add(new A("abc"));

		System.out.println(list);
	}

	public static String fromVarBinary(String hexString) {
		// 바이트 배열의 길이는 HEX 문자열의 절반
		byte[] bytes = new byte[hexString.length() / 2];

		for (int i = 0; i < hexString.length(); i += 2) {
			// 각 2자리 HEX 문자열을 바이트로 변환
			int byteValue = Integer.parseInt(hexString.substring(i, i + 2), 16);
			bytes[i / 2] = (byte) byteValue;
		}

		// 바이트 배열을 다시 문자열로 변환
		return new String(bytes);
	}

	public static String toVarBinary(String idNo) { // mysql BINARY 사용 시 HexString으로 변환됨
		byte[] bytes = idNo.getBytes();

		StringBuilder varBinaryStringBuilder = new StringBuilder();

		for (byte b : bytes) {
			int unsignedByte = b & 0xff;

			String hexString = Integer.toHexString(unsignedByte);

			if (hexString.length() == 1) {
				hexString = "0" + hexString;
			}

			varBinaryStringBuilder.append(hexString);
		}

		return varBinaryStringBuilder.toString();
	}


}

class A {
	private String avc;

	public A(String avc) {
		this.avc = avc;
	}

	public String toString() {
		return avc;
	}
}
