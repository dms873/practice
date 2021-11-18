public class operatorEx26 {
  public static void main(String[] args) {
    int a = 5;
    int b = 0;

    System.out.printf("a=%d, b=%d%n", a, b); // a=5, b=0
    System.out.printf("a!=0 || ++b!=0 = %b%n", a != 0 || ++b != 0); // a!=0 || ++b!=0 = true
    System.out.printf("a=%d, b=%d%n", a, b); // a=5, b=0
    System.out.printf("a==0 && ++b!=0 = %b%n", a == 0 && ++b != 0); // a==0 && ++b!=0 = false
    System.out.printf("a=%d, b=%d%n", a, b); // a=5, b=0
  } // main의 끝
}
