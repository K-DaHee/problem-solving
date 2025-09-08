package BOJ.silver.silver04;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			// 입력으로 주어진 괄호 문자열 문자 배열로 변환
			char[] arr = sc.next().toCharArray();
			
			// 여는 괄호를 담을 스택
			Stack<Character> stack = new Stack<>();
			// 괄호 문자열이 올바른지 체크할 변수
			boolean isOk = false;
			for (char c : arr) {
				// 여는 괄호라면 스택에 넣기
				if(c == '(') {
					stack.push(c);
				}
				// 닫는 괄호일 때
				else {
					// 스택이 비어있지 않고, 스택의 가장 마지막이 여는 괄호라면
					if(!stack.isEmpty() && stack.peek() == '(') {
						// 여는 괄호 꺼내고 올바른 괄호라고 체크
						stack.pop();
						isOk = true;
					}
					// 스택이 비어있는데 닫는 괄호를 만나거나 옳은 괄호가 아니라면
					else {
						// 올바른 괄호가 아니라고 체크하고 반복끝내기
						isOk = false;
						break;
					}
				}
			}
			// 반복이 끝났는데 스택이 비어있지 않다면 올바른 괄호 문자열 아님
			if(!stack.isEmpty()) isOk = false;
			
			// 결과 출력
			if(isOk) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
