package myFirstJava;

public class HelloWorld {
	private int a = 100000000; // 4byte
	private float b = 10.5f; // 4byte, �Ǽ� ���� �⺻ �ڷ����� double��.(f�Ⱦ��� ����)
	private double c = 10.5; // 8byte
	
	private byte d = 127; // 1byte, -128 ~ 127
	private short e = 32500; // 2byte, 65500..
	private long f = 1000000000000000000L; // 8byte, �������� �⺻ �ڷ����� int��.(L�Ⱦ��� ����)
	
	private boolean g = true; // 1byte, true or false�� ����
	private char h = 'a'; // 2byte, ���� 1��. ���� ����ǥ. 
	private char i = 255; // ���� 0~65535���� ���� (����X) �ƽ�Ű�ڵ�
	
	private String str = "abcde"; // ���Ѵ�, ���ڿ�. ū ����ǥ.
	
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
	}
}

//�ּ� : ��ɾ �ƴ�.
/*
* ������ �ּ� ó��
* */
