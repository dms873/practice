public class CastingEx2 {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int i = 10;
    byte b = (byte) i;
    System.out.printf("[int->byte] i=%d -> b=%d%n", i, b); // [int->byte] i=10 -> b=10

    i = 300;
    b = (byte) i;
    System.out.printf("[int->byte] i=%d -> b=%d%n", i, b); // [int->byte] i=300 -> b=44

    b = 10;
    i = (int) b;
    System.out.printf("[byte->int] i=%d -> b=%d%n", b, i); // [byte->int] i=10 -> b=10

    b = -2;
    i = (int) b;
    System.out.printf("[byte->int] i=%d -> i=%d%n", b, i); // [byte->int] i=-2 -> i=-2

    System.out.println("i=" + Integer.toBinaryString(i)); // i=11111111111111111111111111111110
  }
}
