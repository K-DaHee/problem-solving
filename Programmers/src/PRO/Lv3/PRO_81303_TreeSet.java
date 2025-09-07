package PRO.Lv3;

import java.util.Stack;
import java.util.TreeSet;

public class PRO_81303_TreeSet {
	public static void main(String[] args) {
		int n = 8; // 표의 행 개수
		int k = 2; // 처음 선택된 행의 위치
		String[] cmd1 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		String answer = solution(n, k, cmd1);
		System.out.println(answer);
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		answer = solution(n, k, cmd2);
		System.out.println(answer);
	}

	public static String solution(int n, int k, String[] cmd) {
		TreeSet<Integer> alive = new TreeSet<>();	// 삭제되지 않고 현재 테이블에 남아있는 행을 담음
        for (int i = 0; i < n; i++) alive.add(i);
		
		Stack<Integer> deleted = new Stack<>(); // 삭제된 행을 순서대로 넣을 스택

		int current = k;
		int move;

		for (String command : cmd) {
			char c = command.charAt(0); // 맨 앞 글자 체크

			switch (c) {
			case 'U':
				move = Integer.parseInt(command.substring(2));	// 몇 칸 이동할지 체크
				for (int i = 0; i < move; i++) {	// 현재 위치에서 move 칸 만큼 위 행으로 이동
                    current = alive.lower(current);
                }	
				break;
			case 'D':	
				move = Integer.parseInt(command.substring(2));
				for (int i = 0; i < move; i++) {	// 현재 위치에서 move 칸 만큼 아래 행으로 이동
                    current = alive.higher(current);
                }	
				break;
			case 'C':
				// 현재 위치 삭제
				deleted.push(current);	
				alive.remove(current);
				
				// 삭제 후 이동
			    Integer next = alive.higher(current);
			    if (next != null) {
			        current = next; // 아래 행이 있으면 그쪽으로 이동
			    } else {	// 현재 위치가 마지막 행 이었으면
			        current = alive.lower(current); // 위쪽으로 이동
			    }
				break;
			case 'Z':
				if (!deleted.isEmpty())	// 스택이 비어있지 않으면
					alive.add(deleted.pop());	// 이전 삭제 위치 가져옴
				break;

			default:
				break;
			}
		}
		
		// 일단 전체를 O로 채우기
		String[] answerArr = new String[n];
		for (int i = 0; i < answerArr.length; i++) {
			answerArr[i] = "O";
		}

		// 스택에 남아있는 모든 삭제된 행의 위치를 'X'로 변경
		while (!deleted.isEmpty()) {
			int idx = deleted.pop();
			answerArr[idx] = "X";
		}

		// String 배열을 String으로 변환하여 반환
		return String.join("", answerArr);
	}
}
