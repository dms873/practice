public class OverflowEx {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    short sMin = -32768;
    short sMax = 32767;
    char cMin = 0;
    char cMax = 65535;

    System.out.println("sMin = " + sMin); // -32768
    System.out.println("sMin-1 = " + (short) (sMin - 1)); // 32767
    System.out.println("sMax = " + sMax); // 32767
    System.out.println("sMax+1 = " + (short) (sMax + 1)); // -32768
    System.out.println("cMin = " + (int) cMin); // 0
    System.out.println("cMin-1 = " + (int) --cMin); // 65535
    System.out.println("cMax = " + (int) cMax); // 65535
    System.out.println("cMax+1 = " + (int) ++cMax); // 0
  }

  /*
   * sMin(-32768) -1 -> sMax(32767), 최소값 -1 -> 최대값 sMax(32767) +1 -> sMin(-32768),
   * 최대값 +1 -> 최소값 cMin(0) -1 -> cMax(65535), 최소값 -1 -> 최대값 cMax(65535) +1 ->
   * cMin(0), 최대값 +1 -> 최소값
   */
}
