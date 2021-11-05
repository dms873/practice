
public class PrintfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(10/3); // 3 (정수나누기 정수라 정수나옴)
		System.out.println(10.0/3); // 3.3333.. (하나의 숫자를 실수로 바꿔야 함)
		
		System.out.printf("%d%n", 15); // 15 (10진수)
		System.out.printf("%#o%n", 15); // 017 (8진수)
		System.out.printf("%#x%n", 15); // 0xf (16진수)
		// 접두사 붙이려면 '#' 붙이기 (8진수(0), 16진수(0x))
		System.out.printf("%s%n", Integer.toBinaryString(15)); // 1111 이진문자열로 변환 
		
		float f = 123.456789f;
		System.out.printf("%f%n", f); // 123.456787 정밀도 7자리만 정확, 나머지는 의미없음, double타입은 정밀도가 15자리이기 때문에 더 정확함
		System.out.printf("%e%n", f); // 1.234568e+02
		System.out.printf("%g%n", f); // 123.457
		
		System.out.printf("[%5d]%n", 10);  // [   10]  공백으로 자릿수 채우기 
		System.out.printf("[%-5d]%n", 10); // [10   ]  왼쪽 정렬 후 공백으로 자릿수 채우기  
		System.out.printf("[%05d]%n", 10); // [00010]  공백 0으로 채우기 
		// 지정된 값보다 원래값이 크면 지정된 값 무시하고 전체 다 나옴!
		System.out.printf("[%5d]%n", 1234567); // [1234567]
		
		double d = 1.23456789;
		System.out.printf("%f%n", d); // 1.234568 마지막 자릿수는 반올림하여 표기됨 
		System.out.printf("%14.6f%n", d); //       1.234568, 전체자릿수(14) 생략가능 
		
		System.out.printf("[%s]%n", "www.codechobo.com");    // [www.codechobo.com], 정수의 [%d]랑 같음
		System.out.printf("[%20s]%n", "www.codechobo.com");  // [   www.codechobo.com], 20자릿수 나머지는 공백으로 채워짐 
		System.out.printf("[%-20s]%n", "www.codechobo.com"); // [www.codechobo.com   ], 왼쪽 정렬 후 20자릿수 나머지는 공백으로 채워짐 
		System.out.printf("[%.10s]%n", "www.codechobo.com"); // [www.codech], 부분 출력되어 10자리만 표시됨 
	}

}
