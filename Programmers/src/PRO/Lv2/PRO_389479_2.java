package PRO.Lv2;
import java.util.*;

public class PRO_389479_2 {
  public static void main(String[] args) {
      Solution_389479 s = new Solution_389479();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_389479 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        Map<Integer, Integer> servers = new HashMap<>();
        int serverId = 1;

        for (int hour = 0; hour < 24; hour++) {

            final int currentHour = hour;
            
            servers.entrySet().removeIf(entry -> entry.getValue() == currentHour);

            int required = players[hour] / m;

            while (servers.size() < required) {
                servers.put(serverId++, hour + k);
                answer++;
            }
        }

        return answer;
    }
}