package SWEA.D3;

import java.util.Scanner;

public class SWEA_5215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();	// 재료의 수
			int L = sc.nextInt();	// 제한 칼로리
			
			int[][] info = new int[N][2];
			for (int i = 0; i < info.length; i++) {
				info[i][0] = sc.nextInt();
				info[i][1] = sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;	// 최고 점수 값 저장할 변수
			
			// 비트마스킹 이용 모든 조합 탐색
			for (int i = 0; i < (1 << info.length); i++) {
				int score = 0;
				int calorie = 0;
				
				for (int j = 0; j < info.length; j++) {
					if ((i & (1 << j)) != 0) {
						score += info[j][0];
						calorie += info[j][1];
					}
				}
				
				// 현재 조합의 칼로리가 제한을 넘지 않으면 최고 점수 갱신
				if (calorie <= L) {
                    max = Math.max(max, score);
                }
			}
			System.out.printf("#%d %d \n", testCase, max);
		}
	}
}