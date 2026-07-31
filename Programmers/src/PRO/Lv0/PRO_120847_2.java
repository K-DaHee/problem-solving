package PRO.Lv0;


public class PRO_120847_2 {
  public static void main(String[] args) {
      Solution_120847 s = new Solution_120847();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_120847 {
    public int solution(int[] numbers) {
        int max1 = 0;
        int max2 = 0;

        for (int num : numbers) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max1 * max2;
    }
}