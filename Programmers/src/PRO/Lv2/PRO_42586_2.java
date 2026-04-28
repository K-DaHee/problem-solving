package PRO.Lv2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PRO_42586_2 {
  public static void main(String[] args) {
      Solution_42586 s = new Solution_42586();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42586 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            int days = rest / speeds[i];
            if (rest % speeds[i] > 0) days = days + 1;
            q.add(days);
        }

        int count = 1;
        List<Integer> list = new ArrayList<>();
        int current = q.poll();
        while (!q.isEmpty()) {
            int compare = q.peek();
            if (compare <= current) {
                count++;
                q.poll();
            } else {
                list.add(count);
                current = q.poll();
                count = 1;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}