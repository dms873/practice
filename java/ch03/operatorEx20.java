public class operatorEx20 {
  public static void main(String[] args) {
    System.out.println(-10 % 8); // -2
    System.out.println(10 % -8); // 2
    System.out.println(-10 % -8); // -2

    // 나머지 연산자(%)는 나누는 수로 음수도 허용한다. 그러나 부호는 무시한다.

    System.out.println(10 % 8); // 2
    System.out.println(10 % -8); // 2
  }
}
