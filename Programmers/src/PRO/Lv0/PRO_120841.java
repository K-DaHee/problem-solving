package PRO.Lv0;


public class PRO_120841 {
  public static void main(String[] args) {
      Solution_120841 s = new Solution_120841();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_120841 {
    public int solution(int[] dot) {
        int x = dot[0];
        int y = dot[1];

        if (x > 0) {
            return y > 0 ? 1 : 4;
        } else {
            return y > 0 ? 2 : 3;
        }
    }
}