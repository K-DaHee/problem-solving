package SWEA.D1;

import java.util.Scanner;

public class SWEA_2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = 10;
			double sum = 0;
			for (int i = 0; i < n; i++) {
				sum += sc.nextInt();
			}
			long result = Math.round(sum / n);
			System.out.printf("#%d %d\n", testCase, result);
		}
	}
}
