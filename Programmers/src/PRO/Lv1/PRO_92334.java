package PRO.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PRO_92334 {
	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		int[] result = solution(id_list, report, k);
		System.out.println(Arrays.toString(result));

		id_list = new String[] { "con", "ryan" };
		report = new String[] { "ryan con", "ryan con", "ryan con", "ryan con" };
		k = 3;
		result = solution(id_list, report, k);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		// 각 유저가 누구를 신고했는지 기록
		Map<String, HashSet<String>> map = new HashMap<>();
		// 각 유저가 신고당한 횟수 기록
		Map<String, Integer> count = new HashMap<>();
		
		// 초기 빈 데이터 넣기
		for (String id : id_list) {
			map.put(id, new HashSet<>());
			count.put(id, 0);
		}
		
		// 신고 기록 확인해서
		for (String r : report) {
			String[] st = r.split(" ");
			// 신고자의 신고 목록에 신고 당한 사람 추가
			// 해쉬 셋에 추가가 되었을 때만 true 반환됨
			if (map.get(st[0]).add(st[1])) {
				// 새로운 신고의 경우에만 신고당한 횟수 증가
				count.put(st[1], count.get(st[1]) + 1);
			}
		}
		
		// 신고 횟수가 k번 이상인 유저 저장
		HashSet<String> stop = new HashSet<>();
		for (String id : count.keySet()) {
			if (count.get(id) >= k) {
				stop.add(id);
			}
		}
		
		// 결과 담을 배열
		int[] answer = new int[id_list.length];
		// 각 유저가 회신 받은 메일 확인
		for (int i = 0; i < id_list.length; i++) {
			int mail = 0;
			// 유저가 신고한 목록 가져오기
			HashSet<String> set = map.get(id_list[i]);
			
			// 신고한 사람이 정지 명단에 있으면 메일 카운트 증가
			for (String id : set) {
				if (stop.contains(id)) {
					mail++;
				}
			}
			// 최종 받은 메일 수 배열에 입력
			answer[i] = mail;
		}

		return answer;
	}
}
