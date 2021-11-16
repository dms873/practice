public class operatorEx8 {
  public static void main(String args[]) {
    int a = 1_000_000; // 1,000,000 1백만 = 10의 6제곱
    int b = 2_000_000; // 2,000,000 2백만 = 10의 6제곱

    // 10의 12제곱. int의 범위는 10의 9제곱이어서 오버플로우 발생.
    // long c = a * b; // -1454759936;

    // a나 b를 형변환하여 변수에 저장해야된다.(둘 다 해도 상관은 없음)
    long c = (long) a * b; // 2,000,000,000,000;

    System.out.println(c);
  }
}
