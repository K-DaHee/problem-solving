package PRO.Lv2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRO_42586 {
  public static void main(String[] args) {
      Solution_42586 s = new Solution_42586();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayCount = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            // 완성되기까지 남은 수
            double rest = 100 - progresses[i];
            // 스피드에 따라 얼마나 걸리는지 저장
            dayCount[i] += (int) Math.ceil(rest / speeds[i]);
        }

        int count = 0;  // 한 그룹에서 몇 개의 기능이 배포되는지 카운트할 변수
        int standard = dayCount[0]; // 첫 기능을 기준일로 초기화
        List<Integer> temp = new ArrayList<>(); // 결과를 담을 임시 리스트
        for (int nowDay : dayCount) {
            // 현재의 완료일이 기준일보다 늦으면 이전까지 기능 배포
            if (nowDay > standard) {
                temp.add(count);
                // 현재 완료일을 새로운 기준일로 갱신
                standard = nowDay;
                count = 1;
            }
            // 현재의 완료일이 기준일보다 빠르거나 같으면 같은 시기 배포
            else {
                count++;
            }
        }
        temp.add(count);

        int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}