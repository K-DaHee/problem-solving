package BOJ.gold.gold05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	// dn 세로 변경, dm 가로 변경 상하좌우 순
	static int[] dn = { -1, 1, 0, 0 };
	static int[] dm = { 0, 0, -1, 1 };

	static int N, M;
	static int[][] box;
	static Queue<int[]> tomato = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) { // 익은 토마토 미리 넣어두기
					tomato.add(new int[] { i, j });
				}
			}
		}

		bfs();

		int dayCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) { // 익지 않은 토마토가 남았나?
					System.out.println(-1);
					return;
				}
				dayCount = Math.max(dayCount, box[i][j]);	// 익힌 토마토의 최댓값 => 토마토가 마지막으로 익은 날짜
			}
		}
		System.out.println(dayCount - 1); // 익은 토마토 시작 값이 1이기 때문에 -1 해줘야함
	}

	public static void bfs() {
		while (!tomato.isEmpty()) {
			int[] current = tomato.poll();
			int curN = current[0];
			int curM = current[1];

			for (int i = 0; i < 4; i++) {
				int nextN = curN + dn[i];
				int nextM = curM + dm[i];

				// 다음 칸에 대한 유효성 확인
				if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M)
					continue;
				if (box[nextN][nextM] != 0)
					continue; // 이미 익었거나 없는 칸이면 건너뛰기

				box[nextN][nextM] = box[curN][curM] + 1; // 현재 일수에 1씩 더하면서 최대 일수 구하기
				tomato.add(new int[] { nextN, nextM });
			}
		}
	}
}
