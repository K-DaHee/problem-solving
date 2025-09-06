package SWEA.D4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) {
			int caseLength = sc.nextInt();
			char[] str = sc.next().toCharArray();

			Stack<Character> stack = new Stack<>();
			boolean isOk = true;

			for (int i = 0; i < str.length; i++) {
				// 여는 괄호 넣기
				if (str[i] == '(' || str[i] == '[' || str[i] == '{' || str[i] == '<') {
					stack.push(str[i]);
				}
				// 닫는괄호 확인
				else {
					if (stack.isEmpty()) {
						isOk = false;
						break;
					} else {
						char c = stack.pop(); // 검사 실시
						if(!((c == '(' && str[i] == ')') || (c == '<' && str[i] == '>') || (c == '{' && str[i] == '}') || (c == '[' && str[i] == ']'))) {
							isOk = false;
							break;
						}
					}
				}
			}

			// 괄호검사 끝
			if (!isOk || !stack.isEmpty()){
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

	}
}
