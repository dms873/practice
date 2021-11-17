public class operatorEx15 {
  public static void main(String[] args) {

    // 소문자 -> 대문자 변경
    char lowerCase = 'a';
    char upperCase = (char) (lowerCase - 32); // 대문자 A가 소문자 a보다 코드값이 32가 적다.
    // 대문자 -> 소문자 변경
    char upperCase2 = 'A';
    char lowerCase2 = (char) (upperCase2 + 32);
    System.out.println(upperCase); // A
    System.out.println(lowerCase2); // a
  }
}
