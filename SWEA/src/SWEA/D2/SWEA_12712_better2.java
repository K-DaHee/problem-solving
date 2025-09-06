package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12712_better2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = 0, max = 0;
			
			// 십자 계산을 위한 방향
			int[] dxPlus = {-1, 1, 0, 0};
			int[] dyPlus = {0, 0, -1, 1};
			
			// 대각선 계산을 위한 방향
			int[] dxCross = {-1, -1, 1, 1};
			int[] dyCross = {-1, 1, -1, 1};
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					max = Math.max(max, getSum(map, N, M, i, j, dxPlus, dyPlus));
                    max = Math.max(max, getSum(map, N, M, i, j, dxCross, dyCross));
                }
            }

			System.out.println("#" + testCase + " " + max);
		}
	}
	
	public static int getSum(int[][] map, int N, int M, int i, int j, int[] dx, int[] dy) {					
		// sum 초기 값을 현재 위치의 값으로 담음
		int sum = map[i][j];
		// 네 방향 반복
		for (int d = 0; d < 4; d++) {
			// M만큼 스프레이 분사
			for (int k = 1; k < M; k++) {
				int nx = i + dx[d] * k;
				int ny = j + dy[d] * k;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    break;
				
				sum += map[nx][ny];
			}
		}
		return sum;		
	}
}
