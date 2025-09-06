package SWEA.D2;

import java.util.Scanner;

public class SWEA_1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] num = new int[10];
			boolean[] visited = new boolean[10];

			int i = 0;
			int seen = 0;
			while (seen < 10) {
				i++;
				int nextN = N * i;
				while (nextN > 0) {
					int digit = nextN % 10; // 마지막 자리
					if (!visited[digit]) {
						visited[digit] = true;
						seen++;
					}
					nextN /= 10; // 마지막 자리 제거
				}
			}
			System.out.println("#" + testCase + " " + N * i);
		}
	}
}
