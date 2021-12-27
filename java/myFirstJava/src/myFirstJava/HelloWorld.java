package myFirstJava;

public class HelloWorld {
	private int a = 100000000; // 4byte
	private float b = 10.5f; // 4byte, 실수 형의 기본 자료형은 double임.(f안쓰면 오류)
	private double c = 10.5; // 8byte
	
	private byte d = 127; // 1byte, -128 ~ 127
	private short e = 32500; // 2byte, 65500..
	private long f = 1000000000000000000L; // 8byte, 정수형의 기본 자료형은 int임.(L안쓰면 오류)
	
	private boolean g = true; // 1byte, true or false만 가능
	private char h = 'a'; // 2byte, 문자 1개. 작은 따옴표. 
	private char i = 255; // 숫자 0~65535까지 가능 (음수X) 아스키코드
	
	private String str = "abcde"; // 무한대, 문자열. 큰 따옴표.
	
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
	}
}

//주석 : 명령어가 아님.
/*
* 여러줄 주석 처리
* */
