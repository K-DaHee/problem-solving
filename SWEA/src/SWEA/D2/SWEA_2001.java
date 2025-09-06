package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map  = new int[N][N];
			
			// N*N 배열 입력값으로 채우기
			for(int i = 0; i < map.length; i++) {
				// 입력하는 값 한 줄 읽어오고
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < map.length; j++) {
					// 토큰으로 나눠서 한 칸씩 채우기
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int row = 0, col = 0, max = 0;
			
			// M*M의 크기를 총 몇 번 반복하는지
			for (int m = 0; m < (N - M + 1) * (N - M + 1); m++) {
				// 파리의 수를 담을 변수, 반복마다 초기화 되어야하니 반복 안에서 선언
				int sum = 0;
				// 시작 위치에서 M*M 반복하면서 sum에 더하기
                for (int i = row; i < row + M; i++) {
                    for (int j = col; j < col + M; j++) {
                        sum += map[i][j];
                    }
                }
                // 더한 sum값과 max 비교해서 큰 값 max에 담기
                max = Math.max(max, sum);

                // 다음 시작 위치로 이동
                col++;
                if (col > N - M) { // 열 끝나면
                    col = 0;
                    row++; // 다음 행으로 이동
                }
			}
			
			System.out.println("#" + testCase + " " + max);
		}
	}
}