package ch01;

public class VarEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int score = 100;
		// score = 200;
		boolean power = false;

		byte b = 127; // byte : -128 ~ 127

		int oct = 010; // 8진수, 10진수로 8
		int hex = 0x10; // 16진수, 10진수로 16

		long lo = 10_000_000_000L;

		float f = 3.14f;
		double d = 3.14d; // d 생략가능, f로 접미사넣어도 에러X

		char ch = 'A';
		int i = 'A';

		String str = ""; // 빈 문자열(empty string)
		String str2 = "ABCD";
		String str3 = "123";
		String str4 = str2 + str3; // "ABCD123"

		System.out.println("" + 7 + 7); // 77
		System.out.println(7 + 7 + ""); // 14
	}

}
