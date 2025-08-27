package PRO.Lv2;

import java.util.Arrays;

public class PRO_42584 {
	public static void main(String[] args) {
		Solution_42584 s = new Solution_42584();
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(s.solution(prices)));
	}
}
class Solution_42584 {
    public int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				// 1초마다 증가 카운트
				answer[i]++;
				// 가격이 떨어졌다면 카운트 멈춤
		        if (prices[i] > prices[j]) break;
			}
		}
        return answer;
    }
}
