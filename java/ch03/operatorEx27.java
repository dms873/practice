public class operatorEx27 {
  public static void main(String[] args) {
    boolean b = true;
    char ch = 'C';

    System.out.printf("b=%b%n", b); // b=true
    System.out.printf("!b=%b%n", !b); // !b=false
    System.out.printf("!!b=%b%n", !!b); // !!b=true
    System.out.printf("!!!b=%b%n", !!!b); // !!!b=false
    System.out.println();

    System.out.printf("ch=%c%n", ch); // ch=C
    System.out.printf("ch < 'a' || ch > 'z'=%b%n", ch < 'a' || ch > 'z');
    // ch < 'a' || ch > 'z'=true
    System.out.printf("!('a' <= ch && ch <= 'z')=%b%n", !('a' <= ch && ch <= 'z'));
    // !('a' <= ch && ch <= 'z')=true
    System.out.printf(" 'a' <= ch && ch <= 'z' =%b%n", 'a' <= ch && ch <= 'z');
    // 'a' <= ch && ch <= 'z' =false

  } // main의 끝
}

/**
 * !!b -> !!true 가까운 연산자가 먼저 연산된다. -> !false !true의 결과는 false이다. -> true !false의
 * 결과는 true이다.
 */