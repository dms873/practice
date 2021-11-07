import java.util.*; // import문 추가 
// * 대신 Scanner 써도 됨 

public class ScannerEx1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // int num = scanner.nextInt();
    // int num2 = scanner.nextInt();
    // System.out.println(num);
    // System.out.println(num2);

    String input = scanner.nextLine();
    int num = Integer.parseInt(input);
    scanner.close();

    System.out.println(num);
  }

}
