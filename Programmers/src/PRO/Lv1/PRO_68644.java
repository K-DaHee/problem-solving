package PRO.Lv1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PRO_68644 {
    public static void main(String[] args) {
        Solution_68644 s = new Solution_68644();
        System.out.println(Arrays.toString(s.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(s.solution(new int[]{5,0,2,7})));
    }
}

class Solution_68644 {
    public int[] solution(int[] numbers) {
        // TreeSet을 사용한 이유는 자동으로 순서 정렬이 되기 때문
        Set<Integer> set = new TreeSet<>();
        // 배열에서 숫자를 두개 꺼내서 더함. 그 값을 Set에 저장(중복된 수를 저장하지 않기 위함).
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        // 반환 값이 int[]이기 때문에 set에 담긴 수를 배열로 변환
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int num : set){
            answer[idx++] = num;
        }
        return answer;
    }
}
