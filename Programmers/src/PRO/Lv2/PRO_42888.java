package PRO.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRO_42888 {
	public static void main(String[] args) {
		Solution_42888 s = new Solution_42888();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = s.solution(record);
		System.out.println(Arrays.toString(answer));
	}
}

class Solution_42888 {
	public String[] solution(String[] record) {
		// 아이디와 닉네임을 담기 위해 HashMap 선언
		Map<String, String> map = new HashMap<String, String>();
		// record를 공백 단위로 쪼개서 배열로 만들고 Leave아닌 아이디와 이름 업데이트
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			if(arr[0].equals("Leave")) {
				continue;
			}
			map.put(arr[1], arr[2]);
		}
		
		// 출력할 문장 추가해둘 list
		List<String> list = new ArrayList<>();
		// 반복을 따로 나눠서 하는 이유는 바뀐 이름으로 모두 업데이트 된 후 출력 되어야함
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			String name = map.get(arr[1]);	// 이름만 받아두고
			if(arr[0].equals("Enter")){	// Enter라면 "들어왔습니다" 출력
				list.add(name + "님이 들어왔습니다.");
			} else if(arr[0].equals("Leave")) {	// Leave라면 "나갔습니다" 출력
				list.add(name + "님이 나갔습니다.");
			} 
		}
		
		// 받아둔 리스트 배열로 바꿔서 return
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}