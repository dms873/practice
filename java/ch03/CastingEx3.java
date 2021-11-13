public class CastingEx3 {
  public static void main(String[] args) {
    float f = 9.1234567f;
    double d = 9.1234567;
    double d2 = (double) f;

    System.out.printf("f =%20.18f\n", f); // f =9.123456954956055000
    System.out.printf("d =%20.18f\n", d); // d =9.123456700000000000
    System.out.printf("d2 =%20.18f\n", d2); // d2 =9.123456954956055000

    // 같은 값을 저장해도 float와 double의 정밀도 차이 때문에 서로 다른 값이 저장된다.
    // 저장할 때 이미 값이 달라졌기 때문에, 형변환을 해도 값이 같아지지 않는다.
  }
}
