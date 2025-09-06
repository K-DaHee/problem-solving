package SWEA.D3;

import java.util.Scanner;

public class SWEA_1206 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] height = new int[N];
			int sum = 0;
			int maxL, maxR, max;
			for (int i = 0; i < N; i++) {
				height[i] = sc.nextInt();
			}
			for (int j = 2; j < N - 2; j++) {
				maxL = Math.max(height[j - 2], height[j - 1]);
				maxR = Math.max(height[j + 1], height[j + 2]);
				max = Math.max(maxL, maxR);
				if (height[j] > max) {
					sum += (height[j] - max);
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}