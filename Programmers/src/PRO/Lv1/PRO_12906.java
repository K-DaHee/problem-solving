package PRO.Lv1;
import java.util.*;

public class PRO_12906 {
  public static void main(String[] args) {
      Solution_12906 s = new Solution_12906();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_12906 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        int i = 0;
        for(int n : arr) {
            if (list.get(i) == n) continue;
            
            list.add(n);
            i++;
        }
        
        int[] answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}