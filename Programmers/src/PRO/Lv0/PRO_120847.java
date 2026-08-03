package PRO.Lv0;
import java.util.*;

public class PRO_120847 {
  public static void main(String[] args) {
      Solution_120847 s = new Solution_120847();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_120847 {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }
}