public class operatorEx13 {
  public static void main(String[] args) {
    char c1 = 'a';

    // char c2 = c1 + 1; 컴파일 에러 발생
    char c3 = (char) (c1 + 1); // 컴파일 에러 없음(수식에 변수가 들어가 있는 경우에는 형변환 해주어야 함)
    char c2 = 'a' + 1; // 컴파일 에러 없음(컴파일러가 미리 덧셈연산을 수행하기 때문에 실행 시에는 덧셈 연산이 수행되지 않음)

    // 컴파일 전의 코드 -------------> 컴파일 후의 코드
    // char c2 = 'a' + 1; -------> char c2 = 'b';
    // int sec = 60*60*24; ------> int sec = 86400;

    System.out.println(c2); // b
    System.out.println(c3); // b
  }
}
