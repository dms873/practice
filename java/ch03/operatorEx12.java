public class operatorEx12 {
  public static void main(String[] args) {
    char c1 = 'a'; // c1에는 문자 'a'의 코드값인 97이 저장된다.
    char c2 = c1; // c1에 저장되어 있는 값이 c2에 저장된다.
    char c3 = ' '; // c3을 공백으로 초기화 한다.

    int i = c1 + 1; // c1이 char형이므로 int형으로 변환 후 덧셈연산을 수행하게 된다
    // 'a'+1 -> 97+1 -> 98

    c3 = (char) (c1 + 1); // 덧셈연산 c1+1의 결과가 Int이므로 이 결과를 char형 변수 c3에 담기 위해서는 char형으로의 형변환이 필요하다.
    c2++;
    c2++;
    // 형변환없이 c2에 저장되어 있는 값을 1 증가시키므로, 원래 저장되어있던 값(97)이 1씩 두 번 증가되어 99가 된다.
    // 코드값이 99인 문자는 'c'이다.

    System.out.println("i=" + i); // i=98
    System.out.println("c2=" + c2); // c2=c
    System.out.println("c3=" + c3); // c3=b
  }
}
