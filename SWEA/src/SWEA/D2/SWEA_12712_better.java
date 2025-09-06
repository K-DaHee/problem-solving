package SWEA.D2;

import java.util.Scanner;

public class SWEA_12712_better {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0, max = 0;
			
			// 십자 계산을 위한 방향
			int[] dxPlus = {-1, 1, 0, 0};
			int[] dyPlus = {0, 0, -1, 1};
			
			// 대각선 계산을 위한 방향
			int[] dxCross = {-1, -1, 1, 1};
			int[] dyCross = {-1, 1, -1, 1};
			
			// 십자 계산
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					// sum 초기 값을 현재 위치의 값으로 담음
					sum = map[i][j];
					// 네 방향 반복
					for (int d = 0; d < 4; d++) {
						// M만큼 스프레이 분사
						for (int k = 1; k < M; k++) {
							int nx = i + dxPlus[d] * k;
                            int ny = j + dyPlus[d] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                sum += map[nx][ny];
                            }
						}
					}
					max = Math.max(max, sum);
					
					// sum 초기 값을 현재 위치의 값으로 담음
					sum = map[i][j];
					// 네 방향 반복
					for (int d = 0; d < 4; d++) {
						// M만큼 스프레이 분사
						for (int k = 1; k < M; k++) {
							int nx = i + dxCross[d] * k;
                            int ny = j + dyCross[d] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                sum += map[nx][ny];
                            }
						}
					}
					max = Math.max(max, sum);
				}
			}
			

			System.out.println("#" + testCase + " " + max);
		}
	}
}
