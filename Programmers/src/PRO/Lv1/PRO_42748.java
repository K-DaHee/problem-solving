package PRO.Lv1;
import java.util.*;

public class PRO_42748 {
  public static void main(String[] args) {
      Solution_42748 s = new Solution_42748();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int p = 0;
        for (int[] command: commands) {
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;
            
            int[] arr = new int[j - i + 1];
            for (int a = 0; a < arr.length; a++) {
                arr[a] = array[i];
                i++;
            }
            
            Arrays.sort(arr);
            answer[p] = arr[k];
            p++;
        }
        
        return answer;
    }
}