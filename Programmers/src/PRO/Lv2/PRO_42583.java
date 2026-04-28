package PRO.Lv2;
import java.util.*;

public class PRO_42583 {
  public static void main(String[] args) {
      Solution_42583 s = new Solution_42583();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int currentWeight = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            time++;

            currentWeight -= bridge.poll();

            if (currentWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        return time + bridge_length;
    }
}