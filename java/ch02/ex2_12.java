class ex2_12 {
  public static void main(String args[]) {
    String str = "3";

    System.out.println(str.charAt(0) - '0'); // 문자열->문자->숫자, 3
    System.out.println('3' - '0' + 1); // 문자->숫자, 4
    System.out.println(Integer.parseInt("3") + 1); // 문자열->숫자, 4
    System.out.println("3" + 1); // "3"+"1"="31"
    System.out.println(3 + '0'); // '0'은 숫자로 48, 51
    System.out.println((char) (3 + '0')); // 형변환하여 3이 됨
  }
}