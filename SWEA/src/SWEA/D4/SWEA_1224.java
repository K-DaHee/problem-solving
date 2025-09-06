package SWEA.D4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			// 테스트 케이스의 길이
			int t = sc.nextInt();
			// 입력 문자열
			String input = sc.next();

			// 우선순위 Map에 저장
			Map<Character, Integer> priority = new HashMap<>();
			priority.put('*', 2);
			priority.put('+', 1);
			priority.put('(', 0);

			// 최종 후위 표기식 담을 공간
			StringBuilder fix = new StringBuilder();
			// 연산자를 담는 스택
			Stack<Character> op = new Stack<>();

			// 입력받은 테스트 케이스의 길이 만큼 반복 (문자열의 길이로도 가능)
			for (int i = 0; i < t; i++) {
				// 현재 문자 tmp에 저장
				char tmp = input.charAt(i);

				if (tmp >= '0' && tmp <= '9') { // 숫자라면 후위 표기식에 바로 담기
					fix.append(tmp);
				} else if (tmp == '(') { // 열린 괄호라면 연산자 스택에 바로 담기
					op.push('(');
				} else if (tmp == ')') { // 닫힌 괄호라면 연산자 스택에서 열린 괄호가 나올 때까지
					while (op.peek() != '(') { // pop 해서 후위 표기식에 담기
						fix.append(op.pop());
					}
					op.pop(); // 남아있는 열린 괄호 빼주기
				} else { // +, *을 만났을 때
					if (op.isEmpty()) { // 연산자 스택이 비어져 있다면 바로 담기
						op.push(tmp);
					} else {
						// * + 우선순위 비교해서 담기
						// 연산자 스택이 비어있지 않을 때까지 우선순위 비교
						while (priority.get(op.peek()) >= priority.get(tmp) && !op.isEmpty()) {
							fix.append(op.pop());
						}
						op.push(tmp);
					}
				}
			}

			// 연산자 스택에 남은 연산자가 있다면 다 빼서 후위 표기식에 담기
			while (!op.isEmpty()) {
				fix.append(op.pop());
			}

			/* 후위표기식 계산 */
			// 숫자들만 담을 스택
			Stack<Integer> nums = new Stack<>();
			// 담아둔 후위 표기식 만큼 반복
			for (int i = 0; i < fix.length(); i++) {
				// 현재의 문자 tmp에 저장
				char tmp = fix.charAt(i);
				// 숫자라면 nums에 push
				if (tmp >= '0' && tmp <= '9') {
					nums.push(tmp - '0'); // int로 형 변환해서 담기
				} else { // 연산자를 만나면 숫자 두개 pop
					int firstNum = nums.pop();
					int secondNum = nums.pop();

					// 연산자가 더하기라면 더하고 다시 nums에 담아서 값 저장
					if (tmp == '+')
						nums.push(secondNum + firstNum);
					// 연산자가 곱하기라면 다시 nums에 담아서 값 저장
					else if (tmp == '*')
						nums.push(secondNum * firstNum);
				}
			}

			// 스택에 마지막 남아있는 값이 결과 값
			System.out.println("#" + testCase + " " + nums.pop());
		}
	}
}
