package SWEA.D2;

import java.util.Scanner;

public class SWEA_12712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			int sum = 0, max1 = 0, max2 = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					sum = map[i][j];
					for (int k = 1; k < M; k++) {
						if (i - k >= 0) {
							sum += map[i - k][j];
						}
						if (i + k < N) {
							sum += map[i + k][j];
						}
						if (j + k < N) {
							sum += map[i][j + k];
						}
						if(j - k >= 0) {
							sum += map[i][j - k];
						}
					}
					max1 = Math.max(max1, sum);
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					sum = map[i][j];
					for (int k = 1; k < M; k++) {
						if(i - k > 0) {
							if(j - k >= 0) sum += map[i-k][j-k];
							if(j + k < N) sum += map[i-k][j+k];
						}
						if(i + k < N) {
							if(j - k >= 0) sum += map[i+k][j-k];
							if(j + k < N) sum += map[i+k][j+k];
						}
					}
					max2 = Math.max(max2, sum);
				}
			}

			System.out.println("#" + testCase + " " + Math.max(max1, max2));
		}
	}
}
