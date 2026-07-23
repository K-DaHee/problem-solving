package PRO.Lv1;
import java.util.*;

public class PRO_12906_2 {
  public static void main(String[] args) {
      Solution_12906 s = new Solution_12906();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_12906 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}