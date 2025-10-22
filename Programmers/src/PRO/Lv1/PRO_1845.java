package PRO.Lv1;


    public class PRO_1845 {
      public static void main(String[] args) {
          Solution_1845 s = new Solution_1845();
          // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
      }
    }
    

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
			if(set.size() < (nums.length / 2)) {
				set.add(nums[i]);
			}
		}
        
        int answer = set.size();
        return answer;
    }
}