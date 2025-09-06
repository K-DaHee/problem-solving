package BOJ.silver.silver01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 읽기

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 읽어서 공백으로 분리
                rank[i][0] = Integer.parseInt(st.nextToken()); // 서류 심사 순위
                rank[i][1] = Integer.parseInt(st.nextToken()); // 면접 심사 순위
            }
			
			Arrays.sort(rank, (a, b) -> Integer.compare(a[0], b[0]));	// 서류 순위 오름차순 정렬
			
			int count = 1;	// 서류 심사 순위 1등은 무조건 합격
			int interviewRank = rank[0][1];
			for (int i = 1; i < rank.length; i++) {
				if (rank[i][1] < interviewRank) {	// 합격된 사람의 면접 등수와 비교 낮은 등수가 더 좋음!
					count++; // 이 지원자도 합격
                    interviewRank = rank[i][1]; // 최고 등수 갱신
                }
			}
			System.out.println(count);
		}
	}
}
