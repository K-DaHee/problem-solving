package PRO.Lv2;
import java.util.Arrays;

public class PRO_42885 {
  public static void main(String[] args) {
      Solution_42885 s = new Solution_42885();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42885 {
    public int solution(int[] people, int limit) {

        int count = 0;
        int s = 0;
        int e = people.length - 1;

        Arrays.sort(people);

        while (s <= e) {
            int sum = people[s] + people[e];
            if (sum <= limit) {
                s++;
                e--;
                count++;
            } else {
                e--;
                count++;
            }
        }

        int answer = count;
        return answer;
    }
}