public class operatorEx16 {
  public static void main(String args[]) {
    double pi = 3.141592; // 3.141을 얻으려면?

    System.out.println(pi * 1000); // 3141.592;
    System.out.println((int) (pi * 1000)); // 3141;
    System.out.println((int) (pi * 1000) / 1000); // 3;
    System.out.println((int) (pi * 1000) / 1000.0); // 3.141;
  }
}
