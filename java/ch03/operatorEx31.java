public class operatorEx31 {
  public static void main(String[] args) {
    int dec = 1234;
    int hex = 0xABCD;
    int mask = 0xF;

    System.out.printf("hex=%X%n", hex); // hex=ABCD
    System.out.printf("%X%n", hex & mask); // D

    hex = hex >> 4;
    System.out.printf("%X%n", hex & mask); // C

    hex = hex >> 4;
    System.out.printf("%X%n", hex & mask); // B

    hex = hex >> 4;
    System.out.printf("%X%n", hex & mask); // A
  } // main의 끝
}
