public class operatorEx17 {
  public static void main(String args[]) {
    double pi = 3.141592;

    System.out.println(pi); // 3.141592
    System.out.println(pi * 1000); // 3141.592
    System.out.println(Math.round(pi * 1000)); // 3142
    System.out.println(Math.round(pi * 1000) / 1000); // 3 -> int/int
    System.out.println(Math.round(pi * 1000) / 1000.0); // 3.142
    System.out.println((double) Math.round(pi * 1000) / 1000); // 3.142 어느쪽이든 형변환 하면

    // double shortPi = Math.round(pi * 1000) / 1000.0;
    // System.out.println(shortPi);
  }
}
