package PRO.Lv1;
import java.util.Arrays;

public class PRO_42862 {
  public static void main(String[] args) {
      Solution_42862 s = new Solution_42862();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] arr = new int[n + 1];

        int lostNum = lost.length;

        Arrays.sort(lost);

        for(int i = 0; i < reserve.length; i++){
            arr[reserve[i]]++;
        }

        for(int i = 0; i < lost.length; i++){
            if(arr[lost[i]] > 0) {
                arr[lost[i]]--;
                lost[i] = 0;
                lostNum--;
            }
        }


        for(int i = 0; i < lost.length; i++){
            if(lost[i] == 0){continue;}
            if(lost[i] == 1){
                if(arr[lost[i] + 1] > 0){
                    arr[lost[i] + 1]--;
                    lostNum--;
                }
            } else if(lost[i] == n){
                if(arr[lost[i] - 1] > 0){
                    arr[lost[i] - 1]--;
                    lostNum--;
                }
            } else {
                if(arr[lost[i] - 1] > 0){
                    arr[lost[i] - 1]--;
                    lostNum--;
                } else if(arr[lost[i] + 1] > 0){
                    arr[lost[i] + 1]--;
                    lostNum--;
                }
            }
        }

        int answer = n - lostNum;
        return answer;
    }
}