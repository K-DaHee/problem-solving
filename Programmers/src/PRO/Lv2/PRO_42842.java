package PRO.Lv2;


public class PRO_42842 {
  public static void main(String[] args) {
      Solution_42842 s = new Solution_42842();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42842 {
    public int[] solution(int brown, int yellow) {

        int[] answer = {};
        
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int y1 = i;
                int y2 = yellow / i;
                if (y1 * 2 + (y2 + 2) * 2 == brown) {
                    answer = new int[]{y1 + 2, y2 + 2};           
                }
            }
        }
        
        return answer;
    }
}