package SWEA.D2;

import java.util.Scanner;

public class SWEA_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수 입력
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			// N, K 입력
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// map 정보 입력
			int[][] map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 단어가 들어갈 수 있는 자리의 개수 더할 변수
			int total = 0;
			
			// map 반복
			for (int i = 0; i < map.length; i++) {
				// 가로 countW, 세로 countH 한줄 확인 할 때 마다 초기화
				int countW = 0;
				int countH = 0;
				for (int j = 0; j < map.length; j++) {
					// 위치가 1이라면 카운트, 0 만나면 현재까지 카운트가 원하는 단어 크기인지 확인하고 0으로 초기화
					if(map[i][j] == 1) {
						countW++;
					} else {
						if(countW == K) total++;
						countW = 0;
					}
					if(map[j][i] == 1) {
						countH++;
					} else {
						if(countH == K) total++;
						countH = 0;
					}
				}
				// 현재 줄 반복 끝난 후 카운트 다시 확인
				if(countW == K) total++;
				if(countH == K) total++;
			}
			
			System.out.println("#" + testCase + " " + total);
		}
	}
}
