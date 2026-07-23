package PRO.Lv1;
import java.util.*;

public class PRO_42576 {
  public static void main(String[] args) {
      Solution_42576 s = new Solution_42576();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        for (String name : participant) {
            count.put(name, count.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            count.put(name, count.get(name) - 1);
        }

        for (String name : participant) {
            if (count.get(name) > 0) {
                return name;
            }
        }
        
        return "";
    }
}