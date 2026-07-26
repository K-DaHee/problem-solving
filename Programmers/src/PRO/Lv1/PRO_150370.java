package PRO.Lv1;
import java.util.*;

public class PRO_150370 {
  public static void main(String[] args) {
      Solution_150370 s = new Solution_150370();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        int todayDays = convert(today);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            termMap.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }
        
        int i = 1;
        for (String privacy : privacies) {
            String[] temp = privacy.split(" ");
            int collect = convert(temp[0]);
            String termType = temp[1];
            
            int vaildDays = collect + termMap.get(termType);
            
            if (vaildDays <= todayDays) {
                answer.add(i);
            }
            i++;
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    int convert (String date) {
        String[] temp = date.split("\\.");
        int year = Integer.parseInt(temp[0]) * 12 * 28;
        int month = Integer.parseInt(temp[1]) * 28;
        int day = Integer.parseInt(temp[2]);
        
        return year + month + day;
    }
}