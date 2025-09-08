package PRO.Lv3;

import java.util.Stack;

public class PRO_81303 {
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
		Stack<Integer> deleted = new Stack<>(); // 삭제된 행을 순서대로 넣을 스택

		int tableSize = n;
		int current = k;
		int past;
		int move;

		for (int i = 0; i < cmd.length; i++) {
			char c = cmd[i].charAt(0); // 맨 앞 글자 체크

			switch (c) {
			case 'U':
				move = Integer.parseInt(cmd[i].substring(2));	// 몇 칸 이동할지 체크
				current -= move;	// 현재 위치에서 move 칸 만큼 위로 이동
				break;
			case 'D':
				move = Integer.parseInt(cmd[i].substring(2));
				current += move;	// 현재 위치에서 move 칸 만큼 아래로 이동
				break;
			case 'C':
				deleted.push(current);	// 현재 위치 삭제
				tableSize--;	// 테이블 사이즈 하나 감소
				if (current == tableSize)	// 현재 위치가 마지막 행 이었으면 현재 위치 하나 위로 수정
					current--;
				break;
			case 'Z':
				if (!deleted.isEmpty()) {	// 스택이 비어있지 않으면
					past = deleted.pop();	// 이전 삭제 위치 가져옴
					tableSize++;	// 테이블 사이즈 하나 증가
				}
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
