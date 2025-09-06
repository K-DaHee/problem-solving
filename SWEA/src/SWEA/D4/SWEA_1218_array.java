package SWEA.D4;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) {
			int caseLength = sc.nextInt();
			char[] str = sc.next().toCharArray();

			char[] stack = new char[caseLength]; // 배열로 스택 구현
            int top = -1;
            boolean isOk = true;

            for (char ch : str) {
                // 여는 괄호면 배열 담기
                if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                    stack[++top] = ch;
                }
                // 닫는 괄호면 짝 확인
                else {
                    if (top == -1) { // 스택 비었는데 닫는 괄호가 나옴
                        isOk = false;
                        break;
                    }
                    char open = stack[top--];
                    if (!isMatching(open, ch)) {
                        isOk = false;
                        break;
                    }
                }
            }

            // 결과 출력
            if (isOk && top == -1) {
                System.out.println("#" + T + " 1");
            } else {
                System.out.println("#" + T + " 0");
            }
        }
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}') ||
               (open == '<' && close == '>');
    }
}