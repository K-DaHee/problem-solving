package PRO.Lv2;

import java.util.HashMap;

public class PRO_131127 {
	public static void main(String[] args) {
		Solution_131127 s = new Solution_131127();
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };
		int answer = s.solution(want, number, discount);
		System.out.println(answer);
	}
}

class Solution_131127 {
	public int solution(String[] want, int[] number, String[] discount) {
		// 원하는 제품과 개수 HashMap에 저장
		HashMap<String, Integer> wantMap = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}

		int answer = 0;	// 결과를 담을 변수
		
		// 0~10, 1~11 이런식으로 한 칸씩 뒤로 미루면서 10칸 탐색
		int j = 0;
		while (10 + j <= discount.length) {
			// 10일간의 할인 품목을 담을 HashMap
			HashMap<String, Integer> disMap = new HashMap<>();
			for (int i = j; i < 10 + j; i++) {
				// 원하는 제품과 동일한 제품이 disMap에 있다면 
				if (wantMap.containsKey(discount[i])) {
					// 해당 제품의 개수 추가/업데이트, defult 0으로 지정
					disMap.put(discount[i], disMap.getOrDefault(discount[i], 0) + 1);
//					if(disMap.get(discount[i]) == null) disMap.put(discount[i], 1);
//					else disMap.put(discount[i], disMap.get(discount[i]) + 1);
				}
			}
			// 회원가입이 가능한 총 날짜를 구하는 것!
			if(disMap.equals(wantMap)) {
				answer++;
			}
			j++;
		}

		return answer;
	}
}