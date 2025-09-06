package SWEA.D3;

import java.util.Scanner;

public class SWEA_14555 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			char[] arr = sc.next().toCharArray();

			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					count++;
				} else if (arr[i] == ')') {
					// 이전이 '('면 이미 카운트 했으니 무시
					if (i > 0 && arr[i - 1] == '(')
						continue;
					count++;
				}
			}
			System.out.println("#" + testCase + " " + count);
		}
	}
}
