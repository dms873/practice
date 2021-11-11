class operatorEx4 {
  public static void main(String[] args) {
    int i = -10;
    i = +i;
    System.out.println(i); // -10

    i = -10;
    i = -i; // i = -(-10);
    System.out.println(i); // 10
  }
}